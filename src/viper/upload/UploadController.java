package viper.upload;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;

@Resource
@Path("/upload")
public class UploadController {

    private Result result;

    public UploadController(Result result) {
        this.result = result;
    }
    
    @Path("/")
    public void index() {
        
    }

    @Post
    @Path("/upload")
    public void upload(UploadedFile foto) {
        System.out.println("Upload realizado");
        // File fotoSalva = new File("/Users/xbrunnox/download.zip");

        //
        //
        //

        // try {
        // IOUtils.copyLarge(foto.getFile(), new FileOutputStream(fotoSalva));
        // } catch (FileNotFoundException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // } catch (IOException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        // dao.atribui(fotoSalva, perfil);
    }

}
