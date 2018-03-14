package hello

import com.amazonaws.services.lambda.runtime.{Context, RequestHandler}
import org.apache.logging.log4j.LogManager

import scala.collection.JavaConverters

class Handler extends RequestHandler[Request, Response] {


  def handleRequest(input: Request, context: Context): Response = {
    Response("Go Serverless v1.0! Your function executed successfully!", input)
  }
}

class ApiGatewayHandler extends RequestHandler[Request, ApiGatewayResponse] {
  private val logger = LogManager.getLogger(ApiGatewayHandler.this)

  //Not you pathParameters are marshaled to a 'pathParameters' property. You can use java.util.Map as the input object
  //to get everything and examine it (scala map does not work)
  def handleRequest(input: Request, context: Context): ApiGatewayResponse = {
    logger.info("Processing..")
    val headers = Map("x-custom-response-header" -> "my custom response header value")
    ApiGatewayResponse(200, s"Go Serverless v1.0! Your function executed successfully! Message: ${input.pathParameters.message}",
      JavaConverters.mapAsJavaMap[String, Object](headers),
      true)
  }
}
