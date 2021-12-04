package com.redisjiqun;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;

public class RedisClusterCRUD {
    private  static JedisCluster jedisCluster;

    public JedisCluster getJedisCluster(){
        HostAndPort host01 = new HostAndPort("192.168.175.134", 7001);
        HostAndPort host02 = new HostAndPort("192.168.175.134", 7002);
        HostAndPort host03 = new HostAndPort("192.168.175.134", 7003);
        HostAndPort host04 = new HostAndPort("192.168.175.134", 7004);
        HostAndPort host05 = new HostAndPort("192.168.175.134", 7005);
        HostAndPort host06 = new HostAndPort("192.168.175.134", 7006);

        HashSet<HostAndPort> hostAndPorts = new HashSet<HostAndPort>();

        hostAndPorts.add(host01);
        hostAndPorts.add(host02);
        hostAndPorts.add(host03);
        hostAndPorts.add(host04);
        hostAndPorts.add(host05);
        hostAndPorts.add(host06);

        jedisCluster = new JedisCluster(hostAndPorts);
        return jedisCluster;
    }

    //增加
    public void insertClusterInfo(){
        JedisCluster get = this.getJedisCluster();
        String set = get.set("uname", "战狼");
        if (set != null){
            System.out.println("增加成功");
        }else {
            System.out.println("增加失败");
        }
    }

    //删除
    public void deleteClusterInfo(){
        JedisCluster get = this.getJedisCluster();
        Long del = get.del("uname");
        if (del != 0){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }
    //修改
    public void updateCluseterInfo(){
        JedisCluster get = this.getJedisCluster();
        String set = get.set("uname", "战狼2");
        if (set != null){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }
    }
    //查询
    public void selectCluseterInfo(){
        JedisCluster get = this.getJedisCluster();
        String uname = get.get("uname");
        System.out.println(uname);
    }


    public static void main(String[] args) {
        RedisClusterCRUD es = new RedisClusterCRUD();
//        es.insertClusterInfo();
//        es.updateCluseterInfo();
//        es.selectCluseterInfo();
//        es.deleteClusterInfo();
    }
}
