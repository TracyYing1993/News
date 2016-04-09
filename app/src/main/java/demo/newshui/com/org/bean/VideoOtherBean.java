package demo.newshui.com.org.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/3/23.
 */
public class VideoOtherBean {

    /**
     * status : 200
     * data : {"cursor":40,"count":20,"hasNext":1,"videos":[{"site":2,"play_count":10438,"nickname":"莱可亲子","aid":1000000376317,"hor_w8_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_320,h_180/p224/2016/2/4/15/18/6_153880eb25bg104SysCutcloud_82914592_7_4b.jpg","album_hor_small_pic":"http://photocdn.sohu.com/tvpgc/20150522/0_14ce25f156cg201b_43_3.jpg","video_name":"《帮帮龙出动》年夜饭","hor_w6_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_240,h_135/p224/2016/2/4/15/18/6_153880eb25bg104SysCutcloud_82914592_7_4b.jpg","data_type":34,"priority":20,"user_id":245505923,"album_name":"《帮帮龙，出动！》","vid":82914592},{"site":2,"play_count":856469,"nickname":"沃森映画","aid":1000000200534,"hor_w8_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_320,h_180/p223/2014/11/29/10/20/6_14acdcae4eag102SysCutcloud_76646293_7_0b.jpg","album_hor_small_pic":"http://photocdn.sohu.com/tvpgc/20150109/u3439447_149dafa5fbag201b_43_3.jpg","video_name":"翘臀美女公交车上遇痴汉","hor_w6_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_240,h_135/p223/2014/11/29/10/20/6_14acdcae4eag102SysCutcloud_76646293_7_0b.jpg","data_type":34,"priority":21,"user_id":219361108,"album_name":"冷三笑","vid":76646293},{"site":2,"play_count":20377,"nickname":"六一儿童网动漫","aid":1000000551218,"hor_w8_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_320,h_180/p223/2015/7/31/10/0/6_14fb96b495cg102SysCutcloud_80961811_7_1b.jpg","album_hor_small_pic":"http://photocdn.sohu.com/tvpgc/20151116/dXBsb2FkRmlsZV80XzE0NDc2NjQyNjk0NTQ=_43_3.jpg","video_name":"第9集 睡觉","hor_w6_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_240,h_135/p223/2015/7/31/10/0/6_14fb96b495cg102SysCutcloud_80961811_7_1b.jpg","data_type":34,"priority":22,"user_id":222964011,"album_name":"小小逗乐园","vid":80940352},{"site":2,"play_count":100833,"nickname":"飞碟说","aid":1000000362751,"hor_w8_pic":"http://001.img.pu.sohu.com.cn/group2/M01/86/6E/MTAuMTAuODguODE=/dXBsb2FkRmlsZV8zXzE0NTgwODgzNzkxNDc=/cut@m=force,w=320,h=180.jpg","album_hor_small_pic":"http://photocdn.sohu.com/tvpgc/20151112/u3439447_149365695b0g201b_43_3.jpg","video_name":"一分钟教你挑选洗面奶","hor_w6_pic":"http://001.img.pu.sohu.com.cn/group2/M01/86/6E/MTAuMTAuODguODE=/dXBsb2FkRmlsZV8zXzE0NTgwODgzNzkxNDc=/cut@m=force,w=240,h=135.jpg","data_type":34,"priority":23,"user_id":196915464,"album_name":" 飞碟一分钟【第二季】","vid":83205495},{"site":2,"play_count":2569309,"nickname":"秀策坊画动画","aid":1000000389241,"hor_w8_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_320,h_180/p225/2016/2/15/20/3/6_153c1b91d9cg104SysCutcloud_82962643_7_2b.jpg","album_hor_small_pic":"http://photocdn.sohu.com/tvpgc/20160321/216251588_14de075125eg201b_43_3.jpg","video_name":"了不起的白羊座","hor_w6_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_240,h_135/p225/2016/2/15/20/3/6_153c1b91d9cg104SysCutcloud_82962643_7_2b.jpg","data_type":34,"priority":24,"user_id":205055095,"album_name":"星座奇葩事","vid":82962643},{"site":2,"play_count":44302,"nickname":"莱可亲子","aid":1000000376317,"hor_w8_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_320,h_180/p223/2015/9/11/14/5/6_1509538cdbcg104SysCutcloud_81433650_7_7b.jpg","album_hor_small_pic":"http://photocdn.sohu.com/tvpgc/20150522/0_14ce25f156cg201b_43_3.jpg","video_name":"小秘密要告诉妈妈","hor_w6_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_240,h_135/p223/2015/9/11/14/5/6_1509538cdbcg104SysCutcloud_81433650_7_7b.jpg","data_type":34,"priority":25,"user_id":245505923,"album_name":"《帮帮龙，出动！》","vid":81433650},{"site":2,"play_count":294744,"nickname":"沃森映画","aid":1000000200534,"hor_w8_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_320,h_180/p223/2015/9/11/10/15/6_150946595a2g102SysCutcloud_81431529_7_0b.jpg","album_hor_small_pic":"http://photocdn.sohu.com/tvpgc/20150109/u3439447_149dafa5fbag201b_43_3.jpg","video_name":"如何在公园亲吻陌生妹纸","hor_w6_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_240,h_135/p223/2015/9/11/10/15/6_150946595a2g102SysCutcloud_81431529_7_0b.jpg","data_type":34,"priority":26,"user_id":219361108,"album_name":"冷三笑","vid":81431529},{"site":2,"play_count":17595,"nickname":"六一儿童网动漫","aid":1000000551218,"hor_w8_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_320,h_180/p224/2015/7/29/9/28/6_14faf00e58fg104SysCutcloud_80940291_7_2b.jpg","album_hor_small_pic":"http://photocdn.sohu.com/tvpgc/20151116/dXBsb2FkRmlsZV80XzE0NDc2NjQyNjk0NTQ=_43_3.jpg","video_name":"一颗足球引发的搞笑囧事","hor_w6_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_240,h_135/p224/2015/7/29/9/28/6_14faf00e58fg104SysCutcloud_80940291_7_2b.jpg","data_type":34,"priority":27,"user_id":222964011,"album_name":"小小逗乐园","vid":80940291},{"site":2,"play_count":485908,"nickname":"短秀文化","aid":1000000391587,"hor_w8_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_320,h_180/p224/2015/8/5/10/14/6_14fd338993cg104SysCutcloud_81012507_7_0b.jpg","album_hor_small_pic":"http://photocdn.sohu.com/tvpgc/20150528/216251639_14e719073d8g201b_43_3.jpg","video_name":"女生须知：乳房那些事儿","hor_w6_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_240,h_135/p224/2015/8/5/10/14/6_14fd338993cg104SysCutcloud_81012507_7_0b.jpg","data_type":34,"priority":28,"user_id":257622599,"album_name":"逼格学堂","vid":81012507},{"site":2,"play_count":1797644,"nickname":"秀策坊画动画","aid":1000000389241,"hor_w8_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_320,h_180/p224/2016/1/4/19/12/6_152e8b57604g104SysCutcloud_82654075_7_2b.jpg","album_hor_small_pic":"http://photocdn.sohu.com/tvpgc/20160321/216251588_14de075125eg201b_43_3.jpg","video_name":"即使感动也不接受你的爱","hor_w6_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_240,h_135/p224/2016/1/4/19/12/6_152e8b57604g104SysCutcloud_82654075_7_2b.jpg","data_type":34,"priority":29,"user_id":205055095,"album_name":"星座奇葩事","vid":82654075},{"site":2,"play_count":47987,"nickname":"莱可亲子","aid":1000000376317,"hor_w8_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_320,h_180/p225/2015/9/2/17/11/6_150675cea75g104SysCutcloud_81333916_7_0b.jpg","album_hor_small_pic":"http://photocdn.sohu.com/tvpgc/20150522/0_14ce25f156cg201b_43_3.jpg","video_name":"帮帮龙出动：保护牙齿","hor_w6_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_240,h_135/p225/2015/9/2/17/11/6_150675cea75g104SysCutcloud_81333916_7_0b.jpg","data_type":34,"priority":30,"user_id":245505923,"album_name":"《帮帮龙，出动！》","vid":81333916},{"site":2,"play_count":894904,"nickname":"沃森映画","aid":1000000200534,"hor_w8_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_320,h_180/p224/2014/11/27/9/20/6_14ac346f979g102SysCutcloud_76591770_7_7b.jpg","album_hor_small_pic":"http://photocdn.sohu.com/tvpgc/20150109/u3439447_149dafa5fbag201b_43_3.jpg","video_name":"流氓捏美女屁股被大爷狂揍","hor_w6_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_240,h_135/p224/2014/11/27/9/20/6_14ac346f979g102SysCutcloud_76591770_7_7b.jpg","data_type":34,"priority":31,"user_id":219361108,"album_name":"冷三笑","vid":76591770},{"site":2,"play_count":19395,"nickname":"六一儿童网动漫","aid":1000000551218,"hor_w8_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_320,h_180/p223/2015/7/22/11/28/6_14f8b7e4494g102SysCutcloud_80856313_7_2b.jpg","album_hor_small_pic":"http://photocdn.sohu.com/tvpgc/20151116/dXBsb2FkRmlsZV80XzE0NDc2NjQyNjk0NTQ=_43_3.jpg","video_name":"第8集 取刚环","hor_w6_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_240,h_135/p223/2015/7/22/11/28/6_14f8b7e4494g102SysCutcloud_80856313_7_2b.jpg","data_type":34,"priority":32,"user_id":222964011,"album_name":"小小逗乐园","vid":80856313},{"site":2,"play_count":42580,"nickname":"飞碟说","aid":1000000390774,"hor_w8_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_320,h_180/p225/2016/3/17/8/12/196915464_1545fec1fbfg201cloud_1b.jpg","album_hor_small_pic":"http://photocdn.sohu.com/tvpgc/20151112/216251639_14e61d5f57dg201b_43_3.jpg","video_name":"无心睡眠的中国人","hor_w6_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_240,h_135/p225/2016/3/17/8/12/196915464_1545fec1fbfg201cloud_1b.jpg","data_type":34,"priority":33,"user_id":196915464,"album_name":" 飞碟说【第二季】","vid":83215906},{"site":2,"play_count":2125726,"nickname":"秀策坊画动画","aid":1000000389241,"hor_w8_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_320,h_180/p224/2016/1/11/20/7/6_1530cf3c06bg102SysCutcloud_82717937_7_3b.jpg","album_hor_small_pic":"http://photocdn.sohu.com/tvpgc/20160321/216251588_14de075125eg201b_43_3.jpg","video_name":"十二星座公交车遇色狼","hor_w6_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_240,h_135/p224/2016/1/11/20/7/6_1530cf3c06bg102SysCutcloud_82717937_7_3b.jpg","data_type":34,"priority":34,"user_id":205055095,"album_name":"星座奇葩事","vid":82717937},{"site":2,"play_count":34831,"nickname":"莱可亲子","aid":1000000376317,"hor_w8_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_320,h_180/p225/2015/7/10/17/11/6_14f4eec9f25g102SysCutcloud_80730369_8_2b.jpg","album_hor_small_pic":"http://photocdn.sohu.com/tvpgc/20150522/0_14ce25f156cg201b_43_3.jpg","video_name":"帮帮龙出动 我要蜂蜜","hor_w6_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_240,h_135/p225/2015/7/10/17/11/6_14f4eec9f25g102SysCutcloud_80730369_8_2b.jpg","data_type":34,"priority":35,"user_id":245505923,"album_name":"《帮帮龙，出动！》","vid":80730369},{"site":2,"play_count":7230933,"nickname":"沃森映画","aid":1000000200534,"hor_w8_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_320,h_180/p224/2014/11/24/21/23/6_14ab64d403bg102SysCutcloud_76526279_7_5b.jpg","album_hor_small_pic":"http://photocdn.sohu.com/tvpgc/20150109/u3439447_149dafa5fbag201b_43_3.jpg","video_name":"E杯美女不穿内衣遭劫色","hor_w6_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_240,h_135/p224/2014/11/24/21/23/6_14ab64d403bg102SysCutcloud_76526279_7_5b.jpg","data_type":34,"priority":36,"user_id":219361108,"album_name":"冷三笑","vid":76526279},{"site":2,"play_count":25154,"nickname":"六一儿童网动漫","aid":1000000551218,"hor_w8_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_320,h_180/p223/2015/8/12/9/8/6_14ff9318fa3g102SysCutcloud_81096351_7_0b.jpg","album_hor_small_pic":"http://photocdn.sohu.com/tvpgc/20151116/dXBsb2FkRmlsZV80XzE0NDc2NjQyNjk0NTQ=_43_3.jpg","video_name":"第14集 下棋","hor_w6_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_240,h_135/p223/2015/8/12/9/8/6_14ff9318fa3g102SysCutcloud_81096351_7_0b.jpg","data_type":34,"priority":37,"user_id":222964011,"album_name":"小小逗乐园","vid":81096351},{"album_hor_small_pic":"http://photocdn.sohu.com/tvpgc/20150114/216251639_14bbce5ce61g201b_43_3.jpg","site":2,"play_count":274754,"video_name":"简笔笑画《特种兵》","nickname":"JB简笔笑画","priority":38,"data_type":34,"user_id":211261352,"aid":1000000364586,"album_name":"简笔笑画","hor_w8_pic":"http://photocdn.sohu.com/tvpgc/20160127/dXBsb2FkRmlsZV8zXzE0NTM4NjA5Mjg3MTA=_169_2.jpg","vid":82851488},{"album_hor_small_pic":"http://photocdn.sohu.com/tvpgc/20160321/216251588_14de075125eg201b_43_3.jpg","site":2,"play_count":3446219,"video_name":"地球人如何追到奇葩水瓶座","nickname":"秀策坊画动画","priority":39,"data_type":34,"user_id":205055095,"aid":1000000389241,"album_name":"星座奇葩事","hor_w8_pic":"http://photocdn.sohu.com/tvpgc/20160125/6_153565c02cbg102SysCutcloud_82840544_7_0b_169_2.jpg","vid":82840544}]}
     * statusText : OK
     */
    private int status;
    private DataEntity data;
    private String statusText;

    public void setStatus(int status) {
        this.status = status;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public int getStatus() {
        return status;
    }

    public DataEntity getData() {
        return data;
    }

    public String getStatusText() {
        return statusText;
    }

    public class DataEntity {
        /**
         * cursor : 40
         * count : 20
         * hasNext : 1
         * videos : [{"site":2,"play_count":10438,"nickname":"莱可亲子","aid":1000000376317,"hor_w8_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_320,h_180/p224/2016/2/4/15/18/6_153880eb25bg104SysCutcloud_82914592_7_4b.jpg","album_hor_small_pic":"http://photocdn.sohu.com/tvpgc/20150522/0_14ce25f156cg201b_43_3.jpg","video_name":"《帮帮龙出动》年夜饭","hor_w6_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_240,h_135/p224/2016/2/4/15/18/6_153880eb25bg104SysCutcloud_82914592_7_4b.jpg","data_type":34,"priority":20,"user_id":245505923,"album_name":"《帮帮龙，出动！》","vid":82914592},{"site":2,"play_count":856469,"nickname":"沃森映画","aid":1000000200534,"hor_w8_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_320,h_180/p223/2014/11/29/10/20/6_14acdcae4eag102SysCutcloud_76646293_7_0b.jpg","album_hor_small_pic":"http://photocdn.sohu.com/tvpgc/20150109/u3439447_149dafa5fbag201b_43_3.jpg","video_name":"翘臀美女公交车上遇痴汉","hor_w6_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_240,h_135/p223/2014/11/29/10/20/6_14acdcae4eag102SysCutcloud_76646293_7_0b.jpg","data_type":34,"priority":21,"user_id":219361108,"album_name":"冷三笑","vid":76646293},{"site":2,"play_count":20377,"nickname":"六一儿童网动漫","aid":1000000551218,"hor_w8_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_320,h_180/p223/2015/7/31/10/0/6_14fb96b495cg102SysCutcloud_80961811_7_1b.jpg","album_hor_small_pic":"http://photocdn.sohu.com/tvpgc/20151116/dXBsb2FkRmlsZV80XzE0NDc2NjQyNjk0NTQ=_43_3.jpg","video_name":"第9集 睡觉","hor_w6_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_240,h_135/p223/2015/7/31/10/0/6_14fb96b495cg102SysCutcloud_80961811_7_1b.jpg","data_type":34,"priority":22,"user_id":222964011,"album_name":"小小逗乐园","vid":80940352},{"site":2,"play_count":100833,"nickname":"飞碟说","aid":1000000362751,"hor_w8_pic":"http://001.img.pu.sohu.com.cn/group2/M01/86/6E/MTAuMTAuODguODE=/dXBsb2FkRmlsZV8zXzE0NTgwODgzNzkxNDc=/cut@m=force,w=320,h=180.jpg","album_hor_small_pic":"http://photocdn.sohu.com/tvpgc/20151112/u3439447_149365695b0g201b_43_3.jpg","video_name":"一分钟教你挑选洗面奶","hor_w6_pic":"http://001.img.pu.sohu.com.cn/group2/M01/86/6E/MTAuMTAuODguODE=/dXBsb2FkRmlsZV8zXzE0NTgwODgzNzkxNDc=/cut@m=force,w=240,h=135.jpg","data_type":34,"priority":23,"user_id":196915464,"album_name":" 飞碟一分钟【第二季】","vid":83205495},{"site":2,"play_count":2569309,"nickname":"秀策坊画动画","aid":1000000389241,"hor_w8_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_320,h_180/p225/2016/2/15/20/3/6_153c1b91d9cg104SysCutcloud_82962643_7_2b.jpg","album_hor_small_pic":"http://photocdn.sohu.com/tvpgc/20160321/216251588_14de075125eg201b_43_3.jpg","video_name":"了不起的白羊座","hor_w6_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_240,h_135/p225/2016/2/15/20/3/6_153c1b91d9cg104SysCutcloud_82962643_7_2b.jpg","data_type":34,"priority":24,"user_id":205055095,"album_name":"星座奇葩事","vid":82962643},{"site":2,"play_count":44302,"nickname":"莱可亲子","aid":1000000376317,"hor_w8_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_320,h_180/p223/2015/9/11/14/5/6_1509538cdbcg104SysCutcloud_81433650_7_7b.jpg","album_hor_small_pic":"http://photocdn.sohu.com/tvpgc/20150522/0_14ce25f156cg201b_43_3.jpg","video_name":"小秘密要告诉妈妈","hor_w6_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_240,h_135/p223/2015/9/11/14/5/6_1509538cdbcg104SysCutcloud_81433650_7_7b.jpg","data_type":34,"priority":25,"user_id":245505923,"album_name":"《帮帮龙，出动！》","vid":81433650},{"site":2,"play_count":294744,"nickname":"沃森映画","aid":1000000200534,"hor_w8_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_320,h_180/p223/2015/9/11/10/15/6_150946595a2g102SysCutcloud_81431529_7_0b.jpg","album_hor_small_pic":"http://photocdn.sohu.com/tvpgc/20150109/u3439447_149dafa5fbag201b_43_3.jpg","video_name":"如何在公园亲吻陌生妹纸","hor_w6_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_240,h_135/p223/2015/9/11/10/15/6_150946595a2g102SysCutcloud_81431529_7_0b.jpg","data_type":34,"priority":26,"user_id":219361108,"album_name":"冷三笑","vid":81431529},{"site":2,"play_count":17595,"nickname":"六一儿童网动漫","aid":1000000551218,"hor_w8_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_320,h_180/p224/2015/7/29/9/28/6_14faf00e58fg104SysCutcloud_80940291_7_2b.jpg","album_hor_small_pic":"http://photocdn.sohu.com/tvpgc/20151116/dXBsb2FkRmlsZV80XzE0NDc2NjQyNjk0NTQ=_43_3.jpg","video_name":"一颗足球引发的搞笑囧事","hor_w6_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_240,h_135/p224/2015/7/29/9/28/6_14faf00e58fg104SysCutcloud_80940291_7_2b.jpg","data_type":34,"priority":27,"user_id":222964011,"album_name":"小小逗乐园","vid":80940291},{"site":2,"play_count":485908,"nickname":"短秀文化","aid":1000000391587,"hor_w8_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_320,h_180/p224/2015/8/5/10/14/6_14fd338993cg104SysCutcloud_81012507_7_0b.jpg","album_hor_small_pic":"http://photocdn.sohu.com/tvpgc/20150528/216251639_14e719073d8g201b_43_3.jpg","video_name":"女生须知：乳房那些事儿","hor_w6_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_240,h_135/p224/2015/8/5/10/14/6_14fd338993cg104SysCutcloud_81012507_7_0b.jpg","data_type":34,"priority":28,"user_id":257622599,"album_name":"逼格学堂","vid":81012507},{"site":2,"play_count":1797644,"nickname":"秀策坊画动画","aid":1000000389241,"hor_w8_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_320,h_180/p224/2016/1/4/19/12/6_152e8b57604g104SysCutcloud_82654075_7_2b.jpg","album_hor_small_pic":"http://photocdn.sohu.com/tvpgc/20160321/216251588_14de075125eg201b_43_3.jpg","video_name":"即使感动也不接受你的爱","hor_w6_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_240,h_135/p224/2016/1/4/19/12/6_152e8b57604g104SysCutcloud_82654075_7_2b.jpg","data_type":34,"priority":29,"user_id":205055095,"album_name":"星座奇葩事","vid":82654075},{"site":2,"play_count":47987,"nickname":"莱可亲子","aid":1000000376317,"hor_w8_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_320,h_180/p225/2015/9/2/17/11/6_150675cea75g104SysCutcloud_81333916_7_0b.jpg","album_hor_small_pic":"http://photocdn.sohu.com/tvpgc/20150522/0_14ce25f156cg201b_43_3.jpg","video_name":"帮帮龙出动：保护牙齿","hor_w6_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_240,h_135/p225/2015/9/2/17/11/6_150675cea75g104SysCutcloud_81333916_7_0b.jpg","data_type":34,"priority":30,"user_id":245505923,"album_name":"《帮帮龙，出动！》","vid":81333916},{"site":2,"play_count":894904,"nickname":"沃森映画","aid":1000000200534,"hor_w8_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_320,h_180/p224/2014/11/27/9/20/6_14ac346f979g102SysCutcloud_76591770_7_7b.jpg","album_hor_small_pic":"http://photocdn.sohu.com/tvpgc/20150109/u3439447_149dafa5fbag201b_43_3.jpg","video_name":"流氓捏美女屁股被大爷狂揍","hor_w6_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_240,h_135/p224/2014/11/27/9/20/6_14ac346f979g102SysCutcloud_76591770_7_7b.jpg","data_type":34,"priority":31,"user_id":219361108,"album_name":"冷三笑","vid":76591770},{"site":2,"play_count":19395,"nickname":"六一儿童网动漫","aid":1000000551218,"hor_w8_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_320,h_180/p223/2015/7/22/11/28/6_14f8b7e4494g102SysCutcloud_80856313_7_2b.jpg","album_hor_small_pic":"http://photocdn.sohu.com/tvpgc/20151116/dXBsb2FkRmlsZV80XzE0NDc2NjQyNjk0NTQ=_43_3.jpg","video_name":"第8集 取刚环","hor_w6_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_240,h_135/p223/2015/7/22/11/28/6_14f8b7e4494g102SysCutcloud_80856313_7_2b.jpg","data_type":34,"priority":32,"user_id":222964011,"album_name":"小小逗乐园","vid":80856313},{"site":2,"play_count":42580,"nickname":"飞碟说","aid":1000000390774,"hor_w8_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_320,h_180/p225/2016/3/17/8/12/196915464_1545fec1fbfg201cloud_1b.jpg","album_hor_small_pic":"http://photocdn.sohu.com/tvpgc/20151112/216251639_14e61d5f57dg201b_43_3.jpg","video_name":"无心睡眠的中国人","hor_w6_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_240,h_135/p225/2016/3/17/8/12/196915464_1545fec1fbfg201cloud_1b.jpg","data_type":34,"priority":33,"user_id":196915464,"album_name":" 飞碟说【第二季】","vid":83215906},{"site":2,"play_count":2125726,"nickname":"秀策坊画动画","aid":1000000389241,"hor_w8_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_320,h_180/p224/2016/1/11/20/7/6_1530cf3c06bg102SysCutcloud_82717937_7_3b.jpg","album_hor_small_pic":"http://photocdn.sohu.com/tvpgc/20160321/216251588_14de075125eg201b_43_3.jpg","video_name":"十二星座公交车遇色狼","hor_w6_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_240,h_135/p224/2016/1/11/20/7/6_1530cf3c06bg102SysCutcloud_82717937_7_3b.jpg","data_type":34,"priority":34,"user_id":205055095,"album_name":"星座奇葩事","vid":82717937},{"site":2,"play_count":34831,"nickname":"莱可亲子","aid":1000000376317,"hor_w8_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_320,h_180/p225/2015/7/10/17/11/6_14f4eec9f25g102SysCutcloud_80730369_8_2b.jpg","album_hor_small_pic":"http://photocdn.sohu.com/tvpgc/20150522/0_14ce25f156cg201b_43_3.jpg","video_name":"帮帮龙出动 我要蜂蜜","hor_w6_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_240,h_135/p225/2015/7/10/17/11/6_14f4eec9f25g102SysCutcloud_80730369_8_2b.jpg","data_type":34,"priority":35,"user_id":245505923,"album_name":"《帮帮龙，出动！》","vid":80730369},{"site":2,"play_count":7230933,"nickname":"沃森映画","aid":1000000200534,"hor_w8_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_320,h_180/p224/2014/11/24/21/23/6_14ab64d403bg102SysCutcloud_76526279_7_5b.jpg","album_hor_small_pic":"http://photocdn.sohu.com/tvpgc/20150109/u3439447_149dafa5fbag201b_43_3.jpg","video_name":"E杯美女不穿内衣遭劫色","hor_w6_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_240,h_135/p224/2014/11/24/21/23/6_14ab64d403bg102SysCutcloud_76526279_7_5b.jpg","data_type":34,"priority":36,"user_id":219361108,"album_name":"冷三笑","vid":76526279},{"site":2,"play_count":25154,"nickname":"六一儿童网动漫","aid":1000000551218,"hor_w8_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_320,h_180/p223/2015/8/12/9/8/6_14ff9318fa3g102SysCutcloud_81096351_7_0b.jpg","album_hor_small_pic":"http://photocdn.sohu.com/tvpgc/20151116/dXBsb2FkRmlsZV80XzE0NDc2NjQyNjk0NTQ=_43_3.jpg","video_name":"第14集 下棋","hor_w6_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_240,h_135/p223/2015/8/12/9/8/6_14ff9318fa3g102SysCutcloud_81096351_7_0b.jpg","data_type":34,"priority":37,"user_id":222964011,"album_name":"小小逗乐园","vid":81096351},{"album_hor_small_pic":"http://photocdn.sohu.com/tvpgc/20150114/216251639_14bbce5ce61g201b_43_3.jpg","site":2,"play_count":274754,"video_name":"简笔笑画《特种兵》","nickname":"JB简笔笑画","priority":38,"data_type":34,"user_id":211261352,"aid":1000000364586,"album_name":"简笔笑画","hor_w8_pic":"http://photocdn.sohu.com/tvpgc/20160127/dXBsb2FkRmlsZV8zXzE0NTM4NjA5Mjg3MTA=_169_2.jpg","vid":82851488},{"album_hor_small_pic":"http://photocdn.sohu.com/tvpgc/20160321/216251588_14de075125eg201b_43_3.jpg","site":2,"play_count":3446219,"video_name":"地球人如何追到奇葩水瓶座","nickname":"秀策坊画动画","priority":39,"data_type":34,"user_id":205055095,"aid":1000000389241,"album_name":"星座奇葩事","hor_w8_pic":"http://photocdn.sohu.com/tvpgc/20160125/6_153565c02cbg102SysCutcloud_82840544_7_0b_169_2.jpg","vid":82840544}]
         */
        private int cursor;
        private int count;
        private int hasNext;
        private List<VideosEntity> videos;

        public void setCursor(int cursor) {
            this.cursor = cursor;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public void setHasNext(int hasNext) {
            this.hasNext = hasNext;
        }

        public void setVideos(List<VideosEntity> videos) {
            this.videos = videos;
        }

        public int getCursor() {
            return cursor;
        }

        public int getCount() {
            return count;
        }

        public int getHasNext() {
            return hasNext;
        }

        public List<VideosEntity> getVideos() {
            return videos;
        }

        public class VideosEntity {
            /**
             * site : 2
             * play_count : 10438
             * nickname : 莱可亲子
             * aid : 1000000376317
             * hor_w8_pic : http://img.my.tv.sohu.com.cn/o_zoom,w_320,h_180/p224/2016/2/4/15/18/6_153880eb25bg104SysCutcloud_82914592_7_4b.jpg
             * album_hor_small_pic : http://photocdn.sohu.com/tvpgc/20150522/0_14ce25f156cg201b_43_3.jpg
             * video_name : 《帮帮龙出动》年夜饭
             * hor_w6_pic : http://img.my.tv.sohu.com.cn/o_zoom,w_240,h_135/p224/2016/2/4/15/18/6_153880eb25bg104SysCutcloud_82914592_7_4b.jpg
             * data_type : 34
             * priority : 20
             * user_id : 245505923
             * album_name : 《帮帮龙，出动！》
             * vid : 82914592
             */
            private int site;
            private int play_count;
            private String nickname;
            private String aid;
            private String hor_w8_pic;
            private String album_hor_small_pic;
            private String video_name;
            private String hor_w6_pic;
            private int data_type;
            private int priority;
            private int user_id;
            private String album_name;
            private int vid;

            public void setSite(int site) {
                this.site = site;
            }

            public void setPlay_count(int play_count) {
                this.play_count = play_count;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public void setAid(String aid) {
                this.aid = aid;
            }

            public void setHor_w8_pic(String hor_w8_pic) {
                this.hor_w8_pic = hor_w8_pic;
            }

            public void setAlbum_hor_small_pic(String album_hor_small_pic) {
                this.album_hor_small_pic = album_hor_small_pic;
            }

            public void setVideo_name(String video_name) {
                this.video_name = video_name;
            }

            public void setHor_w6_pic(String hor_w6_pic) {
                this.hor_w6_pic = hor_w6_pic;
            }

            public void setData_type(int data_type) {
                this.data_type = data_type;
            }

            public void setPriority(int priority) {
                this.priority = priority;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public void setAlbum_name(String album_name) {
                this.album_name = album_name;
            }

            public void setVid(int vid) {
                this.vid = vid;
            }

            public int getSite() {
                return site;
            }

            public int getPlay_count() {
                return play_count;
            }

            public String getNickname() {
                return nickname;
            }

            public String getAid() {
                return aid;
            }

            public String getHor_w8_pic() {
                return hor_w8_pic;
            }

            public String getAlbum_hor_small_pic() {
                return album_hor_small_pic;
            }

            public String getVideo_name() {
                return video_name;
            }

            public String getHor_w6_pic() {
                return hor_w6_pic;
            }

            public int getData_type() {
                return data_type;
            }

            public int getPriority() {
                return priority;
            }

            public int getUser_id() {
                return user_id;
            }

            public String getAlbum_name() {
                return album_name;
            }

            public int getVid() {
                return vid;
            }
        }
    }
}
