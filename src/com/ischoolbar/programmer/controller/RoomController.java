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
     * ��ѯ����
     * @param page  ��ǰҳ��
     * @param limit ÿҳ��С
     * @return ������Ϣ
     */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView list(ModelAndView model){
		model.setViewName("room/room_list");
		return model;
	}
	
	/**
	 * ��ȡ�꼶�б�
	 * @param name
	 * @param page
	 * @return
	 */
    
    
    
    @RequestMapping("queryRooms.do")
    public Map<String,Object> queryRooms(Integer page, Integer limit){
        //��ȡ��������
        int count = service.getRoomsCount();
        //��ȡ������Ϣ
        List<Room> rooms = service.findRoomsByPage(page,limit);
        //���map
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("code", 0);
        res.put("msg", "");
        res.put("count", count);
        res.put("data", rooms);

        return res;
    }

    /**
     * ��ѯ���н���
     * @return ������Ϣ
     */
    @RequestMapping({"queryAllRooms.do", "teacher/queryAllRooms.do"})
    public List<Room> queryAllRooms(){
        return service.findAllRooms();
    }

    /**
     * ɾ������
     * @param json ���Ҷ����json
     * @return �ɹ�����
     */
    @RequestMapping("deleteRooms.do")
    public Integer deleteRooms(String json){
        if(json.charAt(0) != '[') json = '[' + json + ']';  //�������������ʽ�����������ʽ
        List<Room> rooms = JsonUtil.parseList(json, Room.class);
        return service.deleteRooms(rooms);
    }

    /**
     * ���һ������
     * @param json ���Ҷ����json
     * @return �ɹ���־1
     */
    @RequestMapping("addRoom.do")
    public Integer addRoom(String json){
        Room room = JsonUtil.parseObject(json, Room.class);
        return service.addRoom(room);
    }

    /**
     * �޸�һ������
     * @param json ���Ҷ����json
     * @return �ɹ���־1
     */
    @RequestMapping("updateRoom.do")
    public Integer updateRoom(String json){
        Room room = JsonUtil.parseObject(json, Room.class);
        return service.updateRoom(room);
    }

    /**
     * ��ȡ��������
     * @return ��������
     */
    @RequestMapping("getAmount.do")
    public Integer getAmount() {
        return service.getRoomsCount();
    }

    /**
     * ��������
     * @param page ��ǰҳ��
     * @param limit ÿҳ��С
     * @param json ����������json
     *             {"rname":������,"capacity":����}
     * @return ������Ϣ
     */
    @RequestMapping("searchRooms.do")
    public Map<String,Object> searchRooms(Integer page, Integer limit, String json){
        //��������Ĳ���
        Map<String, Object> searchParam = JsonUtil.parseMap(json, String.class, Object.class);
        //��ȡ��ѯ����
        int count = service.getSearchCount(searchParam);
        //��ѯ������Ϣ
        List<Room> rooms = service.searchRooms(page, limit, searchParam);
        //���map
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("code", 0);
        res.put("msg", "");
        res.put("count", count);
        res.put("data", rooms);
        return res;
    }

}
