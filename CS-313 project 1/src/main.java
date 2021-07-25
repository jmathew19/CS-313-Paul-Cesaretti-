import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.InputStreamReader;


public class main {

	
	public static void main(String[] args) {
		
		
		
		Treap t = new Treap(0, 0);
		BufferedReader reader = null;
		int n =0;
		int k=0;
        try {
            
//        	reader = new BufferedReader( new InputStreamReader (new FileInputStream(args[0])));
        	reader = new BufferedReader( new FileReader("Project1Input.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("couldnt open da file");
        }
        String line = null;
        try {
            line = reader.readLine();
            //System.out.println(line);
        } catch (IOException e) {
            System.out.println("couldnt readline");
        }
        int count = 1;
        
        
        
        while (line != null) {
            String data[] = line.split(",");
            if (count % 2 == 1) {
                 n = Integer.parseInt(data[0]);
                 k = Integer.parseInt(data[1]);
                //System.out.println(data[0]+ " " + data[1] );
                t = new Treap(n, k);
            } else {
               
            	for (int i = 0; i < data.length; i++) {
                   
            		if (data[i].length() >= 1 && (data[i].contains("[") || data[i].contains("]"))) {
                       
            			if (data[i].contains("[")) {
                            data[i] = data[i].substring(1, data[i].length());
                            //System.out.print(Integer.parseInt(data[i]) + " ");
                            t.insert(t, Integer.parseInt(data[i]));
                            //Treap.inArr(Integer.parseInt(data[i]));
                            continue;
                        }
                        
            			if (data[i].contains("]")) {
                            data[i] = data[i].substring(0, data[i].length() - 1);
                            //System.out.println(Integer.parseInt(data[i]) + " ");
                            t.insert(t, Integer.parseInt(data[i]));
                            System.out.println("");
                            //Treap.inArr(Integer.parseInt(data[i]));
                            Treap.subarrays(n,k);
                            System.out.println();
                            System.out.println("-------------------------");
                            
                            continue;
                        
            			}
                    } else {
                        	//System.out.print(Integer.parseInt(data[i]) + " ");
                        	t.insert(t ,Integer.parseInt(data[i]));
                        	//Treap.inArr(Integer.parseInt(data[i]));
                    }

                }
                System.out.println();
            }
            try {
                line = reader.readLine();
            } catch (IOException e) {
                System.out.println("couldnt readline");
            }
            count++;
        }
        
        try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //t = new Treap(n, k);
        //System.out.println("");
        //Treap.subarrays(n, k);
        //t.printInorder(t.getRoot());
       
      


        
        
        
        

      
       
	
	}




	
	
	
	
}
