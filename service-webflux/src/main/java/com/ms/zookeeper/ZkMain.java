package com.ms.zookeeper;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

@Slf4j
public class ZkMain {

    public static void main0(String[] args) throws IOException, InterruptedException {
        String host = "39.97.183.44:2181";
        int timeout = 20000; // milliseconds timeout value
        try (ZooKeeper zooKeeper = new ZooKeeper(host, timeout, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                if (event.getState() == Event.KeeperState.SyncConnected) {
                    log.info("###### zk sync connected...");
                }
            }
        })) {

//            if (null == zooKeeper.exists("/j_client", false)) {
//                String createdPath = zooKeeper.create("/j_client", null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//                log.info("createdPath :: {}", createdPath);
//            }
//
//            for (int i = 0; i < 100; i++) {
//                String path = "/j_client/" + i;
//                String s = zooKeeper.create(path, String.valueOf(i).getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//                log.info("zk create {} for result :: {}", path, s);
//            }

            log.info("get zk node data");
            byte[] data = zooKeeper.getData("/j_client/1", null, null);
            log.info("got /j_client_1 :: {}", new String(data));

//            log.info("update zk node data");
//            int v = zooKeeper.exists("/j_client/1", true).getVersion();
//            Stat stat = zooKeeper.setData("/j_client/1", "changed data".getBytes(), v);
//            log.info("set data stat :: {}", stat.toString());
        } catch (KeeperException e) {
            throw new RuntimeException(e);
        }

    }
}
