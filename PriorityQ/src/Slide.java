
public class Slide implements Comparable<Slide>{

	protected Integer time;
	protected String text;
	
	public Slide(Integer t, String text){
		this.time = t;
		this.text = text;
	}
	
	public int compareTo(Slide s){
		return this.time.compareTo(s.time)*(-1);
	}
	
	public void setText(String text){
		this.text = text;
	}
	
	public String getText(){
		return this.text;
	}
	
	public void setTime(Integer time){
		this.time = time;
	}
	
	public Integer getTime(){
		return time;
	}
	
	
}
