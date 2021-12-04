package com.redis.dome;

import redis.clients.jedis.Jedis;

public class RedisDome {
    public static void selectinfo(){
        Jedis jedis = new Jedis("192.168.175.134", 6379);
        String uname = jedis.get("uanme");
        System.out.println(uname);
    }
    public static void deleteinfo(){
        Jedis jedis = new Jedis("192.168.175.134", 6379);
        Long uname = jedis.del("uname");
    }
    public static void updateinfo(){
        Jedis jedis = new Jedis("192.168.175.134", 6379);
        String set = jedis.set("uanme", "王五");
    }
    public static void insertinfo(){
        Jedis jedis = new Jedis("192.168.175.134", 6379);
        String set = jedis.set("uanme", "wangwu");
    }

    public static void main(String[] args) {
//        RedisDome.insertinfo();
//        RedisDome.selectinfo();
//        RedisDome.updateinfo();
        RedisDome.deleteinfo();
    }
}
