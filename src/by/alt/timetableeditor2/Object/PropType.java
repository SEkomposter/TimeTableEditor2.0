package by.alt.timetableeditor2.Object;


public enum PropType {
    TIMETABLE{
        public String toString(){
            return "timetable";
        }
    },
    USERTIME{
        public String toString(){
            return "userTime";
        }
    },
    GROUPTIME{
        public String toString(){
            return "groupTime";
        }
    }
}
