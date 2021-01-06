package com.kemyond.virus.task;

import com.kemyond.virus.clamav.ClamavCache;
import com.kemyond.virus.dao.HisVirusMapper;
import com.kemyond.virus.domain.HisVirus;
import com.kemyond.virus.util.ClamavUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

/**
 * 线程任务
 * @Author zdl
 * @Date 2021/1/5 16:06
 * @Version 1.0
 */
@Component
public class AutoTask {
   private final static  SimpleDateFormat sdf=new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
   private  static final Logger LOG= LoggerFactory.getLogger(AutoTask.class);
    @Value("${system.finish-file-path}")
    private String finishFilePath;
    @Value("${system.scan-file-path}")
    private String scanFilePath;
   @Autowired
   private HisVirusMapper hisVirusMapper;
    @Autowired
    @Qualifier(value = "scheduledExecutorService")
    private ScheduledExecutorService scheduledExecutorService;

    @Autowired
    private ThreadPoolTaskExecutor executor;
    @PostConstruct
    public void init(){
        Runnable autoScan=new Runnable() {
            @Override
            public void run() {
                if(System.getProperty("os.name").toLowerCase().contains("win")){
                    return;
                }
                while (true){
                    LOG.info(""+ClamavCache.size()+new Date());
                    if(ClamavCache.size()==0){
                        try {
                            Thread.sleep(1000*10);
                        } catch (InterruptedException e) {
                            LOG.error("线程休眠异常",e);
                        }
                    }
                    if(ClamavCache.size()>0&&ClamavCache.size()<100){
                        doScan();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            LOG.error("线程休眠异常",e);
                        }
                    }
                    if(ClamavCache.size()>=100&&ClamavCache.size()<500){
                        doScan();
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            LOG.error("线程休眠异常",e);
                        }
                    }
                    if(ClamavCache.size()>=500){
                        executor.execute(new Runnable() {
                            @Override
                            public void run() {
                                doScan();
                            }
                        });
                    }
                }

            }
        };
        Thread thread=new Thread(autoScan);
        thread.start();
//        scheduledExecutorService.scheduleWithFixedDelay(autoScan,0,1, TimeUnit.SECONDS);
        checkScanFilePath();
    }

    /**
     * 做病毒检测任务,完成检测结果后，将文件移动到已完成目录
     */
    private void doScan() {
        String fileName = ClamavCache.pop();
        Map<String, Object> map = ClamavUtil.scanFile(fileName);
        String sha256 = ClamavUtil.getSha256(fileName);
        ClamavUtil.moveTo(fileName,finishFilePath);
        HisVirus hisVirus=new HisVirus();
        hisVirus.setFileName(fileName);
        hisVirus.setUpdateTime(new Date());
        hisVirus.setFileMark(sha256);
        hisVirus.setDetail(map.get(fileName).toString());
        try {
            LOG.error(map.get("Start Date").toString());
            LOG.error(map.get("End Date").toString());
            hisVirus.setStartTime(sdf.parse(map.get("Start Date").toString()));
            hisVirus.setEndTime(sdf.parse(map.get("End Date").toString()));
            hisVirus.setUpdateTime(new Date());
            hisVirusMapper.insert(hisVirus);
        } catch (ParseException e) {
            LOG.error("时间转换异常",e);
        }
    }

    /**
     * 程序启动检查待扫描目录下是否有文件没有进行扫描，有则将文件加入扫描任务队列中
     */
    public void checkScanFilePath(){
        File file=new File(scanFilePath);
        if(file.exists()){
            File[] files = file.listFiles();
            for (File f:files) {
                String filePath = f.getAbsolutePath();
                ClamavCache.push(filePath);
            }
        }
    }
}
