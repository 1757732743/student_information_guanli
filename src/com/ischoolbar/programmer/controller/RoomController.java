package com.ischoolbar.programmer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ischoolbar.programmer.entity.Room;
import com.ischoolbar.programmer.service.RoomService;
import com.ischoolbar.programmer.util.JsonUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    RoomService service;

    /**
     * 查询教室
     * @param page  当前页码
     * @param limit 每页大小
     * @return 教室信息
     */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView list(ModelAndView model){
		model.setViewName("room/room_list");
		return model;
	}
	
	/**
	 * 获取年级列表
	 * @param name
	 * @param page
	 * @return
	 */
    
    
    
    @RequestMapping("queryRooms.do")
    public Map<String,Object> queryRooms(Integer page, Integer limit){
        //获取教室数量
        int count = service.getRoomsCount();
        //获取教室信息
        List<Room> rooms = service.findRoomsByPage(page,limit);
        //结果map
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("code", 0);
        res.put("msg", "");
        res.put("count", count);
        res.put("data", rooms);

        return res;
    }

    /**
     * 查询所有教室
     * @return 教室信息
     */
    @RequestMapping({"queryAllRooms.do", "teacher/queryAllRooms.do"})
    public List<Room> queryAllRooms(){
        return service.findAllRooms();
    }

    /**
     * 删除教室
     * @param json 教室对象的json
     * @return 成功行数
     */
    @RequestMapping("deleteRooms.do")
    public Integer deleteRooms(String json){
        if(json.charAt(0) != '[') json = '[' + json + ']';  //如果不是数组形式，变成数组形式
        List<Room> rooms = JsonUtil.parseList(json, Room.class);
        return service.deleteRooms(rooms);
    }

    /**
     * 添加一个教室
     * @param json 教室对象的json
     * @return 成功标志1
     */
    @RequestMapping("addRoom.do")
    public Integer addRoom(String json){
        Room room = JsonUtil.parseObject(json, Room.class);
        return service.addRoom(room);
    }

    /**
     * 修改一个教室
     * @param json 教室对象的json
     * @return 成功标志1
     */
    @RequestMapping("updateRoom.do")
    public Integer updateRoom(String json){
        Room room = JsonUtil.parseObject(json, Room.class);
        return service.updateRoom(room);
    }

    /**
     * 获取教室总数
     * @return 教室总数
     */
    @RequestMapping("getAmount.do")
    public Integer getAmount() {
        return service.getRoomsCount();
    }

    /**
     * 搜索教室
     * @param page 当前页码
     * @param limit 每页大小
     * @param json 搜索参数的json
     *             {"rname":教室名,"capacity":容量}
     * @return 教室信息
     */
    @RequestMapping("searchRooms.do")
    public Map<String,Object> searchRooms(Integer page, Integer limit, String json){
        //获得搜索的参数
        Map<String, Object> searchParam = JsonUtil.parseMap(json, String.class, Object.class);
        //获取查询个数
        int count = service.getSearchCount(searchParam);
        //查询教室信息
        List<Room> rooms = service.searchRooms(page, limit, searchParam);
        //结果map
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("code", 0);
        res.put("msg", "");
        res.put("count", count);
        res.put("data", rooms);
        return res;
    }

}
