package ast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ASTCompilationUnitP extends ASTCompilationUnit {

	public ASTCompilationUnitP(String name) {
		super(name);
	}
	public void toFile(){
		this.toSyntax();
		String filename = this.name + ".py";
		File textOutput = new File(filename);
		try {
            textOutput.createNewFile();
            FileOutputStream fos = new FileOutputStream(
                    textOutput.getAbsolutePath());
            fos.write(this.result.getBytes());
            fos.flush();
            fos.close();
        } catch (IOException e) {

            e.printStackTrace();
        }
	}
}
