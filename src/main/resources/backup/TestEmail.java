package backup;



public class TestEmail {
    @Test
    public void testEmail() {
        List<Content> ctts = new ArrayList<Content>();
        TextContent emailTxt = new TextContent(
                "我的email是：miles.wy.1@gmail.com, 欢迎来信！第二个email是：13958
                030335@126.com.^_^");
        ctts.add(emailTxt);
        System.out.println(DesensService.desens(null, ctts, null));
    }
}
