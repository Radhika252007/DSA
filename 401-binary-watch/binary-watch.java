class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> list = new ArrayList<>();
        Time(0,turnedOn,0,0,list);
        return list;

    }
    static void Time(int index, int turnedOn, int Htime, int Mtime, List<String> list){
        if(turnedOn==0){
            if(isSafe(Htime, Mtime)){
               String p = String.format("%d:%02d",Htime,Mtime);
            list.add(p);
            }
            return;
        }
        if(index==10){
            return;
        }
                if(index<4){
                    Time(index+1,turnedOn-1,Htime+(int)Math.pow(2,index),Mtime,list);
                }
                else{
                     Time(index + 1, turnedOn-1,Htime,Mtime+(int)Math.pow(2,index-4),list);
                }
                Time(index+1,turnedOn,Htime,Mtime,list);
        
        


        

    }
    static boolean isSafe(int Htime, int Mtime){
        if(Htime>11 || Mtime > 59){
            return false;
        }
        return true;
    }
}