import java.util.*;
import java.io.*;
public class urinals {
    /**
     * @param args
     */
    public static void main(String[] args) throws IOException {


        int y = 0;

        while(y !=1)
        {
            System.out.println("Pick an option:\n 1 for Keyboard Input \n 2 for File Input \n 3 Exit\n");
            Scanner sc = new Scanner(System.in);
            int choice = Integer.parseInt(sc.nextLine());
            switch(choice)
            {
                case 1:
                    System.out.println("Enter a string:");
                    String input = sc.nextLine();
                    System.out.println("Result: " + counter(input) + "\n");
                    break;
                case 2:
                    String[] stringsArray = readFile();
                    int[] result = new int[stringsArray.length];
                    for(int i=0;i< result.length;i++)
                    {
                        result[i] = counter(stringsArray[i]);
                    }
                    writeFile(result);
                    System.out.println("Results saved in file!\n");
                    break;

                case 3: y=1; break;
            }
        }





    }
    public  static int counter(String ques)
    {
        if(ques.contains("11")) return -1;
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

    public static String[] readFile() throws IOException
    {
        String [] stringsArray = null;
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\vloya1\\Desktop\\urinal.dat"))) {
            List<String> strings = new ArrayList<>();
            br.lines().forEach(c -> strings.add(c));
            stringsArray = strings.toArray(new String[strings.size()]);
        }
        return stringsArray;
    }

    public static void writeFile (int[] result) throws IOException
    {
        String fileName = "rule";

        File file = new File(fileName+ ".txt");
        int count = 0;
        while(!file.createNewFile())
        {
            count++;
            file = new File(fileName+ String.valueOf(count) +".txt");
        }

        String content = "";

        for(int eachResult : result)
        {
            content+=String.valueOf(eachResult)+"\n";

        }

        FileWriter fw = new FileWriter(file);
        fw.write(content);
        fw.close();
    }
}

