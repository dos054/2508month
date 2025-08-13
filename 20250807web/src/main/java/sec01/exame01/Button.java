package sec01.exame01;

public class Button {
	OnClickListener listener;
	
	void setOnClickListener(OnClickListener listner) {
		this.listener = listener;
	}
	
	void touch() {
		listener.onClick();
	}
	
	static interface OnClickListener {
		void onClick();
	}
}
