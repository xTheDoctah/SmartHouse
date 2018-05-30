package it.xthedoctah.spring.common;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CommonsValue {

    public static final String ROOM_LIST_CSV = "./RoomList.csv";

    public static final Path ROOM_LIST_CSV_PATH = Paths.get(CommonsValue.ROOM_LIST_CSV);

    public static final String TEMP_LIST_CSV = "./Temperature.csv";

    public static final int ROOM_AMOUNT = ParserClass.roomAmount();

    public static final List<String[]> ROOM_LIST = ParserClass.roomList();

}
