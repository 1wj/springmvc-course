ch03-receiveParam:��������Ĳ���
��������Ĳ�����ʹ�õĴ��������β�
    1��HttpServletRequest
    2) HttpServletRespone
    3) HttpSession
    4) �û��ύ������

�����û��ύ�Ĳ�����
    1.�������
    2.�������


ע�⣺
        ���ύ����ʱ��get����ʽ����û������
        ʹ��post��ʽ�ύ���������������룬��Ҫʹ�ù����������������⡣

�����������Զ��壬Ҳ����ʹ�ÿ���ṩ�Ĺ����� CharacterEncodingFilter





ʵ�ֲ��裺
1.�½�web maven ����
2.��������
	spring-webMVC��������Ӱ�spring�����������뵽��Ŀ
	jsp��servlet����
3���ص�: ��web.xml��ע��springMVC��ܵĺ��Ķ���dispatcherServlet
	1��DispatcherServlet�����������������һ��servlet�����ĸ����Ǽ̳�HttpServlet
	2��DispatcherServletҳ����ǰ�˿�������front controller��
	3��DispatcherServlet��������û��ύ�����󣬵��������Ŀ���������
		��������Ĵ�������ʾ���û�
4.����һ�����������ҳ�� index.jsp

5.����һ���������ࣨ�����ࣩ
	1��������������@Controllerע�⣬�������󣬲����뵽springMVC������
	2������ķ����������@RequestMappingע��

6.����һ����Ϊjsp����ʾ����Ĵ�����

7.����springMVC�������ļ���spring�������ļ�һ����
	1���������ɨ������ָ��@Controllerע�����ڵİ���
	2��������ͼ������������������ͼ��
