package com.redisjiqun.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;

public class RedisClusterCRUDxml {
    private  static JedisCluster jedisCluster;

    public JedisCluster getJedisCluster(){
        ClassPathXmlApplicationContext get = new ClassPathXmlApplicationContext("Redis.xml");
        JedisCluster getBean = get.getBean("jedisCluster", JedisCluster.class);
        return getBean;
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
        RedisClusterCRUDxml es = new RedisClusterCRUDxml();
//        es.insertClusterInfo();
//        es.updateCluseterInfo();
        es.selectCluseterInfo();
//        es.deleteClusterInfo();
    }
}
