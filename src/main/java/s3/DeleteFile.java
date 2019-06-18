package s3;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

public class DeleteFile {

    public static void main(String[] args) {

        final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();

        String bucket_name = "jjjmybucket112";
        String object_key = "aj.java";

        try{

            s3.deleteObject(bucket_name,object_key);

        } catch (AmazonServiceException e){

            System.err.println("Amazon Service Error :: "+ e.getMessage());
        }

    }
}
