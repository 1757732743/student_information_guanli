package com.ischoolbar.programmer.dao;

import com.ischoolbar.programmer.entity.Room;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RoomDao {
    /**
     * ��ӽ���
     * @param room
     * @return
     */
    int insertRoom(Room room);

    /**
     * ɾ������
     * @param rooms
     * @return
     */
    int deleteRooms(List<Room> rooms);

    /**
     * �޸Ľ���
     * @param room
     * @return
     */
    int updateRoom(Room room);

    /**
     * ��ѯ���н���
     * @return
     */
    List<Room> selectRooms();

    /**
     * ����id��ѯ����
     * @param id
     * @return
     */
    Room selectRoom(Integer id);

    /**
     * ��ҳ��ѯ����
     * @param begin ��ʼ��������0��ʼ
     * @param size  ÿҳ��С
     * @return
     */
    List<Room> selectRoomsByLimit(@Param("begin") int begin, @Param("size")int size);

    /**
     * ��ȡ��������
     * @return
     */
    int getRoomsCount();

    /**
     * ��ҳ��������
     * @param map 4��������begin,size,mname,mdept
     * @return
     */
    List<Room> searchRoomsByLimit(Map<String,Object> map);

    /**
     * ��ȡ����������
     * @param map 2��������mname,mdept
     * @return
     */
    int getSearchCount(Map<String,Object> map);
}
