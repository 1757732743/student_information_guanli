package com.ischoolbar.programmer.service;

import com.ischoolbar.programmer.entity.Room;

import java.util.List;
import java.util.Map;

public interface RoomService {

    /**
     * �����еĽ���
     * @return
     */
    List<Room> findAllRooms();

    /**
     * ��ҳ�����н���
     * @param page
     * @param size
     * @return
     */
    List<Room> findRoomsByPage(int page, int size);

    /**
     * ��ȡ��������
     * @return
     */
    int getRoomsCount();

    /**
     * ɾ��ָ������
     * @param rooms
     * @return ɾ���ɹ�������
     */
    int deleteRooms(List<Room> rooms);

    /**
     * ���һ������
     * @param room
     */
    int addRoom(Room room);

    /**
     * �޸�һ������
     * @param room
     * @return
     */
    int updateRoom(Room room);

    /**
     * ��������
     * @param page
     * @param size
     * @param searchParam
     */
    List<Room> searchRooms(Integer page, Integer size, Map<String, Object> searchParam);

    /**
     * ��ȡ����������
     * @param searchParam
     * @return
     */
    int getSearchCount(Map<String, Object> searchParam);

}
