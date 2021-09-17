package kjh_Manager.movieInfo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Blob {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BlobMain bm = new BlobMain();
		/*
		int result = bm.test2();
		System.out.println(result);
		*/
		
		FileVO fv = bm.test();
		
		File file = new File("src/img/a6.png");
		FileOutputStream fos = new FileOutputStream(file);
		
		System.out.println("전송완료");
		
		fos.write(fv.getBlob());
		fos.close();
		
		
		
		
		// System.out.println(fv);
	}

}
