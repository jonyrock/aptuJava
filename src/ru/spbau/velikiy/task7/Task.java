package spbau.velikiy.task7;

/**
 * Structure class Task is used by Worker
 */
public class Task {
    // value for increment
    public final int i;
    // task id
    public final int id;
    // task status
    public boolean isDone;
    // task result
    public int result;
    
    public Task(int i, int id){
        this.i = i;
        this.id = id;
        this.isDone = false; 
    }
    
    public void setResult(int res){
        isDone = true;
        result = res;
    }
    
}
