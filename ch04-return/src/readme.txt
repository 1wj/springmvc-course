ch04-return:�����������ķ���ֵ��ʾ����Ĵ�����
1.ModelAndView�������ݺ���ͼ������ͼִ��forward
2.String:��ʾ��ͼ�������߼����ƣ�Ҳ��������������ͼ·��
3.void�����ܱ�ʾ���ݣ�Ҳ���ܱ�ʾ��ͼ��
            �ڴ���ajaxʱ������ʹ��void����ֵ��ͬHttpServletResponse������ݣ�
            ��Ӧajax����ajax����������˷��صľ������ݣ�����ͼ�޹�
4.Object������String��Integer��Map,list,Student �ȵȶ��Ƕ���
    ���������ԣ����Ծ������ݣ����з���Object��ʾ���ݣ�����ͼ�޹�
    ����ʹ�ö����ʾ���ݣ���Ӧajax����

    ������ajax����Ҫʹ��json�����ݸ�ʽ��ʵ�ֲ��裺
    1.���봦��json�Ĺ��߿��������springmvcĬ��ʹ�õ�Jackson��
    2.��springmvc�����ļ�֮�����<mvc:annotation-driven> ע������ ��java������json����
        json = om.writeValueAsString(Student);
        <mvc:annotation-driven>�ڼ��˵�springmvc�����ļ��󣬻��Զ�����HttpMessageConverter�ӿڵ�7��ʵ�������
        ���� NappingJackson2HttpNessageConverter(ʹ��jackson���߿��е�objectNapperʵ��java����תΪjson)

    3.�ڴ������������������@ResponseBodyע�� ��ͨ��HttpservletResponse�������,����json�����ǰ��,����Ӧajax����ġ�
       response.setContentType("application/json;charset=utf-8");
       PrintWriter out=response.getWriter();
       out.println(json);

    springmvc��������������Object������תΪjson��������������Ӧajax���ڲ�ԭ��
1.<mvc:annotation-driven> ע������
        ע����������Ҫ���������java����json��xml.text�������Ƶ����ݸ�ʽ��ת����
        HttpMessageConveter�ӿڣ���Ϣת������
        ���ܣ�������javaתΪjson��xml�����ݸ�ʽ�ķ���������ӿ��кܶ�ʵ���ࡣ
        ��Щʵ�������java����json��java����xml��java���󵽶��������ݸ�ʽ��ת��

    ��������������ǿ�������ѽ������������ʱʹ�õ�:
    boolean canwrite(class<?> var1��@Nullable MediaType var2);
    void write(T var1��@Nullable MediaType var2��HttpoutputMessage var3)
    ���紦��������
    @RequestMapping("/doReturnView2")
    public student doReturnView2(HttpServletRequest request,string name��Integer age){
            student student = new student();
            student.setName("lisi");
            student.setAge(20);
            return student;
    }
    1 ) canwrite���ü�鴦���������ķ���ֵ���ܲ���תΪvar2��ʾ�����ݸ�ʽ��
        ���student(lisi , 20)�ܲ���תΪvar2��ʾ�����ݸ�ʽ����������תΪjson , canwrite����true
        MediaType:��ʾ����ʽ�ģ�����json , xml�ȵ�
    2 ) write:�Ѵ����������ķ���ֵ���󣬵���jackson�е�objectMapperתΪjson�ַ�����
        json = om.writevalueAsstring(student);

2.@ResponseBodyע��
    ���ڴ��������������棬ͨ��HttpservletResponse������ݣ���Ӧajax����ġ�
    Printwriter pw= response.getwriter();
    pw.println(json);
    pw.flush();
    pw.close();





