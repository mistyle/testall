//package com.example.demo.controller;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.demo.common.NeoProperties;
//
//import net.sf.json.JSONObject;
//
////@Slf4j
//@RestController
//public class HelloWorldController {
//
//	 private  final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);
//
//	@Autowired
//	NeoProperties  neo;
//
//	@RequestMapping(value = "/hello", method = RequestMethod.GET)
//    @ResponseBody
//    public String hello(@RequestParam String name) {
//        return "Hello " + name;
//    }
//
////	@RequestMapping("/hello")
////	public String hello() throws Exception {
////	    throw new Exception("发生错误");
////	}
////
//	@RequestMapping("/say")
//    public String say(@RequestParam String word) {
//        return "Hello World ! "+word;
//    }
//
//	@RequestMapping("/wo")
//    public String wo() {
//        return "Hello Worldaa   ! ";
//    }
//
//	@RequestMapping("/wo1")
//    public String wo1() {
//        return "Hello Worldaa 1111  ! ";
//    }
//
//	 /**
//	    * 测试接受消息通知
//	    * @param object
//	    * @throws Exception
//	    */
//		@RequestMapping(value="/test", method=RequestMethod.POST)
//		public String   tests(@RequestBody NoticeObject bean) throws Exception {
//
//			//System.out.println("aaaaa"+content);
//
//			// JSONObject jsonObject = JSONObject.fromObject( content );
//			// NoticeObject bean =(NoticeObject) JSONObject.toBean( jsonObject );
//
//			//NoticeObject  object=(NoticeObject)SerializeUtil.deserialize(content.getBytes());
//			//aaaaa{"serviceRequestId":"REQ058292992","type":1,"message":"12222"}
//		   System.out.println(bean.getServiceRequestId());
//		   System.out.println(bean.getType());
//
//		   JSONObject jsonObject = JSONObject.fromObject( bean.getMessage() );
//		   CompletionMessageObject messageObj=(CompletionMessageObject)JSONObject.toBean(jsonObject, CompletionMessageObject.class);
//
//
//			//CompletionMessageObject   messageObj  =jsonObject.to
//			System.out.println(jsonObject.get("status"));
//			System.out.println(jsonObject.get("cardPhone"));
//			System.out.println(messageObj.getCardPhone());
//			System.out.println(messageObj.getDesc());
//			System.out.println(messageObj.getOperateType());
//			System.out.println(messageObj.getSendTime());
//			System.out.println(messageObj.getStatus());
//
//			String ss="{\"code\":\"2\",\"dec\":xxx,\"object\":1}";
//			return ss;
//		}
//
//
//
//}
