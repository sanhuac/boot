package com.byc.merchants.merchants_cms;



import com.byc.merchants.merchants_cms.bean.user.User;
import com.byc.merchants.merchants_cms.service.redis.RedisService;
import com.byc.merchants.merchants_cms.util.RedisKeyUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: 胡丛
 * @Date: 2018/9/5 13:56
 * @Description: redis测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisConfigTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Resource
    private ValueOperations<String,Object> valueOperations;

    @Autowired
    private HashOperations<String, String, Object> hashOperations;

    @Autowired
    private ListOperations<String, Object> listOperations;

    @Autowired
    private SetOperations<String, Object> setOperations;

    @Autowired
    private ZSetOperations<String, Object> zSetOperations;

    @Resource
    private RedisService redisService;

    @Test
    public void testObj() throws Exception{
        User user = new User();
        user.setMerId(1);
        user.setMerName("胡丛");
        ValueOperations<String,Object> operations = redisTemplate.opsForValue();
        redisService.expireKey("name",20, TimeUnit.SECONDS);
        String key = RedisKeyUtil.getKey("user","name",user.getMerName());
        User vo = (User) operations.get(key);
        System.out.println(vo);
    }

    @Test
    public void testValueOption( )throws  Exception{
        User user = new User();
        user.setMerId(1);
        user.setMerName("胡丛");
        valueOperations.set("upload",user);
        System.out.println(valueOperations.get("upload"));
    }

    @Test
    public void testSetOperation() throws Exception{
        User user = new User();
        user.setMerId(1);
        user.setMerName("胡丛");
        User auserVo = new User();
        user.setMerId(1);
        user.setMerName("胡丛");
        setOperations.add("user:upload",user,auserVo);
        Set<Object> result = setOperations.members("user:upload");
        System.out.println(result);
    }

    @Test
    public void HashOperations() throws Exception{
        User userVo = new User();
        userVo.setMerId(1);
        userVo.setMerName("胡丛");
        hashOperations.put("hash:user",userVo.hashCode()+"",userVo);
        System.out.println(hashOperations.get("hash:user",userVo.hashCode()+""));
    }

    @Test
    public void  ListOperations() throws Exception{
        User userVo = new User();
        userVo.setMerId(1);
        userVo.setMerName("胡丛");
//        listOperations.leftPush("list:user",userVo);
//        System.out.println(listOperations.leftPop("list:user"));
        // pop之后 值会消失
        System.out.println(listOperations.leftPop("list:user"));
    }
}
