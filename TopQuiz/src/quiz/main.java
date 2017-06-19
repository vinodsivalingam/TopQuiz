/*OOAD assignment 3 
 * Vinod Kumar Sivalingam
 * A Swing-based interactive quiz
 * The target group may be first to 5th graders
 * 
 * This is the main class which calls the new quiz start class which creates a quiz 
 */
package quiz;
import java.io.FileNotFoundException;

class main{  
   
    public static void main(String[] args) throws FileNotFoundException
    {
    	quizapp q=new quizapp();
        q.quizstart();

    }
}
