package impl;


import java.io.*;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import stockage.Fichier;



public class FichierInt implements Fichier{

	private String fp;
	private RandomAccessFile f;
	private int nupletSize;
	private int currentLength;
	private Logger logger = Logger.getLogger(TableInt.class.getName());

	
	public FichierInt(String filePath, int nupletSize){
		this.fp = filePath;
		this.nupletSize = nupletSize;
	}

	public void store(int pos, Object o) {
		try {
			this.f = new RandomAccessFile(this.fp, "rw");
			byte[] b = new byte[nupletSize];
			for(int i=0;i<nupletSize;i++) {
				
				b[i] = (byte)((NupletInt) o).getAtt(i);
					
			}
				
			this.f.seek(pos*nupletSize);
			this.f.write(b);
			this.f.close();
			PropertyConfigurator.configure("log4j.properties");
			logger.info("INSERT : "+o+" FILE :"+this.fp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object get(int pos) {
		try {
			this.f = new RandomAccessFile(this.fp, "rw");
			byte[] b = new byte[nupletSize];
			this.f.seek(pos*nupletSize);
			f.read(b);
			f.close();
			return new NupletInt(b);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public long getCurrentSize() {
		return this.currentLength;
	}
	

	
	

}
