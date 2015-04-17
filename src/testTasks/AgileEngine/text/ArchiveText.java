package testTasks.AgileEngine.text;

public class ArchiveText {
//    input: "aaaaabbcccddddddaaa"
//    output: "5a2b3c6d3a"

    String archiveString(String text) {
        char curSymbol;
        char prevSymbol = text.charAt(0);//'a'
        int count = 1;
        String result = "";
        for (int i=1; i < text.length(); i++){
            curSymbol = text.charAt(i);//'b'
            if (curSymbol  == prevSymbol){//false b!= a
                count++;//count=5
            }else{
                result += "" + count + prevSymbol;//result = "" + "" + 5 + a = 5a
                count = 1;
                prevSymbol = curSymbol; //'b'
            }

        }

        result += "" + count + prevSymbol;//result = "" + "" + 5 + a = 5a


        return result;
    }
}

