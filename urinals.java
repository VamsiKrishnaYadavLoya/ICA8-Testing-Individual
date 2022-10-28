import java.util.*;
import java.io.*;
public class urinals {
    /**
     * @param args
     */
    public static void main(String[] args) throws IOException {
        String [] stringsArray = null;
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\vloya1\\Desktop\\urinal.dat"))) {
            List<String> strings = new ArrayList<>();
            br.lines().forEach(c -> strings.add(c));
            stringsArray = strings.toArray(new String[strings.size()]);
        }

        int[] result = new int[stringsArray.length];
        int i=0;
        for(String eachString: stringsArray)
        {
           result[i++] = counter(eachString);
        }
        String fileName = "rule";

        File file = new File(fileName+ ".txt");
        int count = 0;
        while(!file.createNewFile())
        {
            count++;
            file = new File(fileName+ String.valueOf(count) +".txt");
        }

        
    }
    public  static int counter(String ques)
    {
        int prev = 0;
        int count = 0;

        for(int i=0;i<ques.length();i++)
        {
            char ch = ques.charAt(i);
            if(prev == 0)
            {

                if(ch == '1') {prev = 1; continue;}

                else if(ch == '0')
                {
                    if(i == ques.length()-1) {
                        count++;
                        prev = 1;
                        continue;
                    }
                    else{
                        if(ques.charAt(i+1)=='0')
                        {
                            prev = 1;
                            count++;
                        }
                    }

                }

            }
            else if(prev == 1)
            {
                if(ch == '0') prev = 0;
            }
        }
        return count;
    }

}

