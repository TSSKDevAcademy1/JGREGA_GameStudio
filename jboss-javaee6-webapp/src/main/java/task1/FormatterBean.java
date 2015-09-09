package task1;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class FormatterBean {
		
		@Inject		
//		@Informal // Ak chcem vypisat implementaciu rozhrania ktore ma anotaciu @Informal tak tu pridam informal ak ju nedam berie @Default
		private Messager messager; //  vytvory mi nieco ako objekt ktory implementuje rozhranie Messager 
		
		public String getFormattedMessage(){
			return messager.getMessage().toUpperCase();
		}
}
