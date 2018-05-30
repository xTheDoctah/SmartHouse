package it.xthedoctah.spring.common;

import java.util.List;

public class CommonsValue {
    /*String*/
    public static final String ROOM_LIST_CSV = "./RoomList.csv";
    public static final String TEMP_LIST_CSV = "./Temperature.csv";
    /*Int*/
    public static final int ROOM_AMOUNT = ParserClass.roomAmount();
    /*Various*/
    public static final List<String[]> ROOM_LIST = ParserClass.roomList();

}
