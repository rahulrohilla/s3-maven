package s3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AmazonS3Exception;

import java.io.File;

public class UploadS3 {

    public static void main(String[] args) {

        final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();

        String bucket_name = "jjjmybucket112";
        String key_name = "aj.java";
        String path ="/Users/rahulrohilla/Documents/aj.java";


        try{

            s3.putObject(bucket_name,key_name,new File(path));

        }catch(AmazonS3Exception e){

            System.err.println(e.getErrorMessage());
            System.exit(1);


        }



    }
}
