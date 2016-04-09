package demo.newshui.com.org.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/3/21.
 *
 *新闻汇实体类
 */
public class NewsBean{



    private ShareReadEntity shareRead;

    private String channelName;


    private SubInfoEntity subInfo;
    private int mainFocalId;
    private int channelId;
    private int lastUpdateTime;
    private String type;
    private String shareContent;
    private String token;
    private int isDefault;
    private int preload;
    private int localType;
    private int focusPosition;
    private int viceFocalId;


    private List<ArticlesEntity> articles;

    public void setShareRead(ShareReadEntity shareRead) {
        this.shareRead = shareRead;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public void setSubInfo(SubInfoEntity subInfo) {
        this.subInfo = subInfo;
    }

    public void setMainFocalId(int mainFocalId) {
        this.mainFocalId = mainFocalId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public void setLastUpdateTime(int lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setShareContent(String shareContent) {
        this.shareContent = shareContent;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setIsDefault(int isDefault) {
        this.isDefault = isDefault;
    }

    public void setPreload(int preload) {
        this.preload = preload;
    }

    public void setLocalType(int localType) {
        this.localType = localType;
    }

    public void setFocusPosition(int focusPosition) {
        this.focusPosition = focusPosition;
    }

    public void setViceFocalId(int viceFocalId) {
        this.viceFocalId = viceFocalId;
    }

    public void setArticles(List<ArticlesEntity> articles) {
        this.articles = articles;
    }

    public ShareReadEntity getShareRead() {
        return shareRead;
    }

    public String getChannelName() {
        return channelName;
    }

    public SubInfoEntity getSubInfo() {
        return subInfo;
    }

    public int getMainFocalId() {
        return mainFocalId;
    }

    public int getChannelId() {
        return channelId;
    }

    public int getLastUpdateTime() {
        return lastUpdateTime;
    }

    public String getType() {
        return type;
    }

    public String getShareContent() {
        return shareContent;
    }

    public String getToken() {
        return token;
    }

    public int getIsDefault() {
        return isDefault;
    }

    public int getPreload() {
        return preload;
    }

    public int getLocalType() {
        return localType;
    }

    public int getFocusPosition() {
        return focusPosition;
    }

    public int getViceFocalId() {
        return viceFocalId;
    }

    public List<ArticlesEntity> getArticles() {
        return articles;
    }

    public static class ShareReadEntity {
        private int sourceType;
        private String pics;
        private String title;
        private int subId;
        private String description;
        private String link;
        private String fromLink;
        private String from;
        private String picSize;
        private int hasTV;
        private int subCount;

        public void setSourceType(int sourceType) {
            this.sourceType = sourceType;
        }

        public void setPics(String pics) {
            this.pics = pics;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setSubId(int subId) {
            this.subId = subId;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public void setFromLink(String fromLink) {
            this.fromLink = fromLink;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public void setPicSize(String picSize) {
            this.picSize = picSize;
        }

        public void setHasTV(int hasTV) {
            this.hasTV = hasTV;
        }

        public void setSubCount(int subCount) {
            this.subCount = subCount;
        }

        public int getSourceType() {
            return sourceType;
        }

        public String getPics() {
            return pics;
        }

        public String getTitle() {
            return title;
        }

        public int getSubId() {
            return subId;
        }

        public String getDescription() {
            return description;
        }

        public String getLink() {
            return link;
        }

        public String getFromLink() {
            return fromLink;
        }

        public String getFrom() {
            return from;
        }

        public String getPicSize() {
            return picSize;
        }

        public int getHasTV() {
            return hasTV;
        }

        public int getSubCount() {
            return subCount;
        }
    }

    public static class SubInfoEntity {
        private String subName;
        private int subId;

        public void setSubName(String subName) {
            this.subName = subName;
        }

        public void setSubId(int subId) {
            this.subId = subId;
        }

        public String getSubName() {
            return subName;
        }

        public int getSubId() {
            return subId;
        }
    }

    public static class ArticlesEntity {
        private int statsType;
        private int isHasAudio;
        private int isHasTv;
        private String pos;
        private int isRecom;
        private int templateType;
        private int isHasSponsorships;
        private int isPreload;
        private int isWeather;
        private int carouselTime;
        private int isFlash;
        private int newsType;
        private int templateId;
        private int commentNum;
        private String playTime;
        private int newsId;
        private String title;
        private List<String> pics;
        private String time;
        private String iconNight;
        private String hostTeam;
        private String visitorTeam;
        private String hostTotal;
        private String visitorTotal;
        private String iconText;
        private String bgPic;



        /**
         * cursor : 4662402
         * statsType : 0
         * pos : 1
         * isRecom : 0
         * time : 1458556615000
         * updateTime : 1458556615013
         * isFlash : 0
         * newsType : 4
         * commentNum : 963
         * playTime : 0
         * channelNewsId : 4662402
         * link : photo://newsId=123264233&updateTime=1458556615013&from=channel&channelId=1&isHasSponsorships=1&position=1&page=1
         * isHasAudio : 0
         * isHasTv : 0
         * title : 案值上亿!海关破获蟒蛇皮走私案
         * templateType : 3
         * pics : ["http://n1.itc.cn/img7/adapt/wb/focal/2016/03/21/145855665633503147_480_236.JPEG"]
         * isHasSponsorships : 0
         * isHasVote : 0
         * isPreload : 0
         * isWeather : 0
         * templateId : 0
         * newsId : 123264233
         */

        private List<NewsItemsEntity> newsItems;
        /**
         * position : 18
         * scope : 4-20
         * link : http://win.dx168.com/wap/20160316tjx/index.html?sid=1648&reffer=1514701
         * data : {"position":"18","du":0,"weight":70,"form":"info_pictxt","viewmonitor":"turn%3D1%09hours%3D","tag":1458576846,"impressionid":"bc71d5ce96cbd56b860e80d361d2df9901:53152A1134E3455010099A0DD004AA33DFA2E3C1D61077769C469EF663E40C3647C4FF4C4081AE0963AEE97826130BABD9EAB9233CAA97CBEDA11E7F4754D8D7194AF1BFEC98F1371972329CC1E472B30261092CBD26A98E87D7C6412955345D1D6372DF771FBA027D6061EFC0AFE5C15B75C52D57C97C6948354E6714E705EBCA1C645F7546F654339DFDA92D80C79D8885D624175A0DB08D81A8B2D314F6A23A16AF35FAE5DA906ABDC6B20518720C:1:0:29_self_rank_37_n:1458626948:1458489600:1462031999:920213388525568:0:5.4.1","resource":{"text":"","admaster_imp":[],"width":360,"imp":[],"click_imp":[],"click":"http://win.dx168.com/wap/20160316tjx/index.html?sid=1648&reffer=1514701","type":"image","miaozhen_click_imp":[],"height":234,"file":"http://images.sohu.com/saf/a2016/0321/wKiDRFbvvxaAFES_AABJY14a1ac788360x234.jpg","md5":"20reC0x730000000SbJ103VWk","miaozhen_imp":[],"adcode":"http://images.sohu.com/saf/a2016/0321/wKiDRFbvvxaAFES_AABJY14a1ac788360x234.jpg","admaster_click_imp":[]},"onform":1,"offline":1462031999,"size":"3000:1","online":1458489600,"clickmonitor":"turn%3D1%09hours%3D","adid":"937708_12355","itemspaceid":"12355","special":{"dict":{"summary":"resource2","picture":"resource","title":"resource1"}},"resource2":{"text":"","admaster_imp":[],"imp":[],"miaozhen_imp":[],"md5":"20reC0x730000000SbJ103VWk","click_imp":[],"click":"http://win.dx168.com/wap/20160316tjx/index.html?sid=1648&reffer=1514701","adcode":"","type":"text","miaozhen_click_imp":[],"admaster_click_imp":[]},"monitorkey":"20reC0x730000000SbJ103VWk","resource1":{"text":"22小时改变你的账户余额","admaster_imp":[],"imp":[],"miaozhen_imp":[],"md5":"20reC0x730000000SbJ103VWk","click_imp":[],"click":"http://win.dx168.com/wap/20160316tjx/index.html?sid=1648&reffer=1514701","adcode":"22小时改变你的账户余额","type":"text","miaozhen_click_imp":[],"admaster_click_imp":[]}}
         * rc : 1
         * gbcode : 1156440100
         * adType : 1
         * appchn : 3313
         * newschn : 1
         * adp_type : 10
         * lc : 1
         * abposition : 18
         * iconDay : http://cache.k.sohu.com/img8/wb/2014/04/09/1397037794612.png
         */

        private int position;
        private String scope;
        private String link;
        /**
         * position : 18
         * du : 0
         * weight : 70
         * form : info_pictxt
         * viewmonitor : turn%3D1%09hours%3D
         * tag : 1458576846
         * impressionid : bc71d5ce96cbd56b860e80d361d2df9901:53152A1134E3455010099A0DD004AA33DFA2E3C1D61077769C469EF663E40C3647C4FF4C4081AE0963AEE97826130BABD9EAB9233CAA97CBEDA11E7F4754D8D7194AF1BFEC98F1371972329CC1E472B30261092CBD26A98E87D7C6412955345D1D6372DF771FBA027D6061EFC0AFE5C15B75C52D57C97C6948354E6714E705EBCA1C645F7546F654339DFDA92D80C79D8885D624175A0DB08D81A8B2D314F6A23A16AF35FAE5DA906ABDC6B20518720C:1:0:29_self_rank_37_n:1458626948:1458489600:1462031999:920213388525568:0:5.4.1
         * resource : {"text":"","admaster_imp":[],"width":360,"imp":[],"click_imp":[],"click":"http://win.dx168.com/wap/20160316tjx/index.html?sid=1648&reffer=1514701","type":"image","miaozhen_click_imp":[],"height":234,"file":"http://images.sohu.com/saf/a2016/0321/wKiDRFbvvxaAFES_AABJY14a1ac788360x234.jpg","md5":"20reC0x730000000SbJ103VWk","miaozhen_imp":[],"adcode":"http://images.sohu.com/saf/a2016/0321/wKiDRFbvvxaAFES_AABJY14a1ac788360x234.jpg","admaster_click_imp":[]}
         * onform : 1
         * offline : 1462031999
         * size : 3000:1
         * online : 1458489600
         * clickmonitor : turn%3D1%09hours%3D
         * adid : 937708_12355
         * itemspaceid : 12355
         * special : {"dict":{"summary":"resource2","picture":"resource","title":"resource1"}}
         * resource2 : {"text":"","admaster_imp":[],"imp":[],"miaozhen_imp":[],"md5":"20reC0x730000000SbJ103VWk","click_imp":[],"click":"http://win.dx168.com/wap/20160316tjx/index.html?sid=1648&reffer=1514701","adcode":"","type":"text","miaozhen_click_imp":[],"admaster_click_imp":[]}
         * monitorkey : 20reC0x730000000SbJ103VWk
         * resource1 : {"text":"22小时改变你的账户余额","admaster_imp":[],"imp":[],"miaozhen_imp":[],"md5":"20reC0x730000000SbJ103VWk","click_imp":[],"click":"http://win.dx168.com/wap/20160316tjx/index.html?sid=1648&reffer=1514701","adcode":"22小时改变你的账户余额","type":"text","miaozhen_click_imp":[],"admaster_click_imp":[]}
         */

        private DataEntity data;
        private int rc;
        private String gbcode;
        private int adType;
        private String appchn;
        private String newschn;
        private int adp_type;
        private int lc;
        private int abposition;
        private String iconDay;


        public void setStatsType(int statsType) {
            this.statsType = statsType;
        }

        public void setIsHasAudio(int isHasAudio) {
            this.isHasAudio = isHasAudio;
        }

        public void setIsHasTv(int isHasTv) {
            this.isHasTv = isHasTv;
        }

        public void setPos(String pos) {
            this.pos = pos;
        }

        public void setIsRecom(int isRecom) {
            this.isRecom = isRecom;
        }

        public void setTemplateType(int templateType) {
            this.templateType = templateType;
        }

        public void setIsHasSponsorships(int isHasSponsorships) {
            this.isHasSponsorships = isHasSponsorships;
        }

        public void setIsPreload(int isPreload) {
            this.isPreload = isPreload;
        }

        public void setIsWeather(int isWeather) {
            this.isWeather = isWeather;
        }

        public void setCarouselTime(int carouselTime) {
            this.carouselTime = carouselTime;
        }

        public void setIsFlash(int isFlash) {
            this.isFlash = isFlash;
        }

        public void setNewsType(int newsType) {
            this.newsType = newsType;
        }

        public void setTemplateId(int templateId) {
            this.templateId = templateId;
        }

        public void setCommentNum(int commentNum) {
            this.commentNum = commentNum;
        }

        public void setPlayTime(String playTime) {
            this.playTime = playTime;
        }

        public void setNewsId(int newsId) {
            this.newsId = newsId;
        }

        public void setNewsItems(List<NewsItemsEntity> newsItems) {
            this.newsItems = newsItems;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getIconNight() {
            return iconNight;
        }

        public void setIconNight(String iconNight) {
            this.iconNight = iconNight;
        }

        public String getHostTeam() {
            return hostTeam;
        }

        public void setHostTeam(String hostTeam) {
            this.hostTeam = hostTeam;
        }

        public String getVisitorTeam() {
            return visitorTeam;
        }

        public void setVisitorTeam(String visitorTeam) {
            this.visitorTeam = visitorTeam;
        }

        public String getHostTotal() {
            return hostTotal;
        }

        public void setHostTotal(String hostTotal) {
            this.hostTotal = hostTotal;
        }

        public String getVisitorTotal() {
            return visitorTotal;
        }

        public void setVisitorTotal(String visitorTotal) {
            this.visitorTotal = visitorTotal;
        }

        public String getIconText() {
            return iconText;
        }

        public void setIconText(String iconText) {
            this.iconText = iconText;
        }

        public String getBgPic() {
            return bgPic;
        }

        public void setBgPic(String bgPic) {
            this.bgPic = bgPic;
        }

        public List<String> getPics() {
            return pics;
        }

        public void setPics(List<String> pics) {
            this.pics = pics;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public int getStatsType() {
            return statsType;
        }

        public int getIsHasAudio() {
            return isHasAudio;
        }

        public int getIsHasTv() {
            return isHasTv;
        }

        public String getPos() {
            return pos;
        }

        public int getIsRecom() {
            return isRecom;
        }

        public int getTemplateType() {
            return templateType;
        }

        public int getIsHasSponsorships() {
            return isHasSponsorships;
        }

        public int getIsPreload() {
            return isPreload;
        }

        public int getIsWeather() {
            return isWeather;
        }

        public int getCarouselTime() {
            return carouselTime;
        }

        public int getIsFlash() {
            return isFlash;
        }

        public int getNewsType() {
            return newsType;
        }

        public int getTemplateId() {
            return templateId;
        }

        public int getCommentNum() {
            return commentNum;
        }

        public String getPlayTime() {
            return playTime;
        }

        public int getNewsId() {
            return newsId;
        }

        public List<NewsItemsEntity> getNewsItems() {
            return newsItems;
        }
        public String getTitle() {
            return title;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public void setScope(String scope) {
            this.scope = scope;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public void setData(DataEntity data) {
            this.data = data;
        }

        public void setRc(int rc) {
            this.rc = rc;
        }

        public void setGbcode(String gbcode) {
            this.gbcode = gbcode;
        }

        public void setAdType(int adType) {
            this.adType = adType;
        }

        public void setAppchn(String appchn) {
            this.appchn = appchn;
        }

        public void setNewschn(String newschn) {
            this.newschn = newschn;
        }

        public void setAdp_type(int adp_type) {
            this.adp_type = adp_type;
        }

        public void setLc(int lc) {
            this.lc = lc;
        }

        public void setAbposition(int abposition) {
            this.abposition = abposition;
        }

        public void setIconDay(String iconDay) {
            this.iconDay = iconDay;
        }

        public int getPosition() {
            return position;
        }

        public String getScope() {
            return scope;
        }

        public String getLink() {
            return link;
        }

        public DataEntity getData() {
            return data;
        }

        public int getRc() {
            return rc;
        }

        public String getGbcode() {
            return gbcode;
        }

        public int getAdType() {
            return adType;
        }

        public String getAppchn() {
            return appchn;
        }

        public String getNewschn() {
            return newschn;
        }

        public int getAdp_type() {
            return adp_type;
        }

        public int getLc() {
            return lc;
        }

        public int getAbposition() {
            return abposition;
        }

        public String getIconDay() {
            return iconDay;
        }


        public static class NewsItemsEntity {
            private int cursor;
            private int statsType;
            private String pos;
            private int isRecom;
            private String time;
            private String updateTime;
            private int isFlash;
            private int newsType;
            private int commentNum;
            private String playTime;
            private int channelNewsId;
            private String link;
            private int isHasAudio;
            private int isHasTv;
            private String title;
            private int templateType;
            private int isHasSponsorships;
            private int isHasVote;
            private int isPreload;
            private int isWeather;
            private int templateId;
            private int newsId;
            private List<String> pics;
            /**
             * position : 3
             * scope : 4-20
             * data : {"position":"3","du":3,"weight":50,"form":"info_bannertxt","viewmonitor":"%09hours%3D","tag":1458539824,"impressionid":"6b6e5b082fb850806a1a0661fab01fb800:DD38BFD89FE9E1E8C0351C0A63066DDACC6F9954A6A32D9A82047B36D7C7202255F44905E76E862DAB256781B727C2BAB828C29AA9C405215201101A5E151030CD1550305F33ADA244475BB9C728AE99:1:0:priority_n:1458561429:1458536884:1458950400:920213388525568:0:5.4.1","resource":{"text":"","admaster_imp":[],"width":656,"imp":["http://imp.optaim.com/201603/84ec2dbfdd861fcd00de8d6b54a8b640.php?a=99"],"click_imp":[],"click":"http://clk.optaim.com/event.ng/Type=click&FlightID=201603&TargetID=sohu&Values=84ec2dbf,dd861fcd,00de8d6b,54a8b640&AdID=11117025","type":"image","miaozhen_click_imp":[],"height":324,"file":"http://images.sohu.com/saf/a2016/0321/wKiDRFbvg7OANlPVAACrIFqoBaU097656x324.jpg","md5":"20rpH0x610000000S74103VtV","miaozhen_imp":[],"adcode":"http://images.sohu.com/saf/a2016/0321/wKiDRFbvg7OANlPVAACrIFqoBaU097656x324.jpg","admaster_click_imp":[]},"onform":1,"offline":1458950400,"size":"3000:1","online":1458536884,"clickmonitor":"%09hours%3D","adid":"935947_13015","itemspaceid":"13015","special":{"dict":{"picture":"resource","title":"resource1"}},"monitorkey":"20rpH0x610000000S74103VtV","resource1":{"text":"搜狐新闻新功能：定制开机图","admaster_imp":[],"imp":["http://imp.optaim.com/201603/84ec2dbfdd861fcd00de8d6b54a8b640.php?a=99"],"miaozhen_imp":[],"md5":"20rpH0x610000000S74103VtV","click_imp":[],"click":"http://clk.optaim.com/event.ng/Type=click&FlightID=201603&TargetID=sohu&Values=84ec2dbf,dd861fcd,00de8d6b,54a8b640&AdID=11117025","adcode":"搜狐新闻新功能：定制开机图","type":"text","miaozhen_click_imp":[],"admaster_click_imp":[]}}
             * rc : 1
             * gbcode : 1156440100
             * adType : 1
             * appchn : 3313
             * newschn : 1
             * adp_type : 16
             * lc : 1
             * abposition : 3
             * iconText : 推广
             * iconNight : http://cache.k.sohu.com/img8/wb/2014/04/09/1397037875352.png
             * iconDay : http://cache.k.sohu.com/img8/wb/2014/04/09/1397037794612.png
             */

            private int position;
            private String scope;
            /**
             * position : 3
             * du : 3
             * weight : 50
             * form : info_bannertxt
             * viewmonitor : %09hours%3D
             * tag : 1458539824
             * impressionid : 6b6e5b082fb850806a1a0661fab01fb800:DD38BFD89FE9E1E8C0351C0A63066DDACC6F9954A6A32D9A82047B36D7C7202255F44905E76E862DAB256781B727C2BAB828C29AA9C405215201101A5E151030CD1550305F33ADA244475BB9C728AE99:1:0:priority_n:1458561429:1458536884:1458950400:920213388525568:0:5.4.1
             * resource : {"text":"","admaster_imp":[],"width":656,"imp":["http://imp.optaim.com/201603/84ec2dbfdd861fcd00de8d6b54a8b640.php?a=99"],"click_imp":[],"click":"http://clk.optaim.com/event.ng/Type=click&FlightID=201603&TargetID=sohu&Values=84ec2dbf,dd861fcd,00de8d6b,54a8b640&AdID=11117025","type":"image","miaozhen_click_imp":[],"height":324,"file":"http://images.sohu.com/saf/a2016/0321/wKiDRFbvg7OANlPVAACrIFqoBaU097656x324.jpg","md5":"20rpH0x610000000S74103VtV","miaozhen_imp":[],"adcode":"http://images.sohu.com/saf/a2016/0321/wKiDRFbvg7OANlPVAACrIFqoBaU097656x324.jpg","admaster_click_imp":[]}
             * onform : 1
             * offline : 1458950400
             * size : 3000:1
             * online : 1458536884
             * clickmonitor : %09hours%3D
             * adid : 935947_13015
             * itemspaceid : 13015
             * special : {"dict":{"picture":"resource","title":"resource1"}}
             * monitorkey : 20rpH0x610000000S74103VtV
             * resource1 : {"text":"搜狐新闻新功能：定制开机图","admaster_imp":[],"imp":["http://imp.optaim.com/201603/84ec2dbfdd861fcd00de8d6b54a8b640.php?a=99"],"miaozhen_imp":[],"md5":"20rpH0x610000000S74103VtV","click_imp":[],"click":"http://clk.optaim.com/event.ng/Type=click&FlightID=201603&TargetID=sohu&Values=84ec2dbf,dd861fcd,00de8d6b,54a8b640&AdID=11117025","adcode":"搜狐新闻新功能：定制开机图","type":"text","miaozhen_click_imp":[],"admaster_click_imp":[]}
             */

            private DataEntity data;
            private int rc;
            private String gbcode;
            private int adType;
            private String appchn;
            private String newschn;
            private int adp_type;
            private int lc;
            private int abposition;
            private String iconText;
            private String iconNight;
            private String iconDay;


            public int getCursor() {
                return cursor;
            }

            public void setCursor(int cursor) {
                this.cursor = cursor;
            }

            public int getStatsType() {
                return statsType;
            }

            public void setStatsType(int statsType) {
                this.statsType = statsType;
            }

            public String getPos() {
                return pos;
            }

            public void setPos(String pos) {
                this.pos = pos;
            }

            public int getIsRecom() {
                return isRecom;
            }

            public void setIsRecom(int isRecom) {
                this.isRecom = isRecom;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public int getIsFlash() {
                return isFlash;
            }

            public void setIsFlash(int isFlash) {
                this.isFlash = isFlash;
            }

            public int getNewsType() {
                return newsType;
            }

            public void setNewsType(int newsType) {
                this.newsType = newsType;
            }

            public int getCommentNum() {
                return commentNum;
            }

            public void setCommentNum(int commentNum) {
                this.commentNum = commentNum;
            }

            public String getPlayTime() {
                return playTime;
            }

            public void setPlayTime(String playTime) {
                this.playTime = playTime;
            }

            public int getChannelNewsId() {
                return channelNewsId;
            }

            public void setChannelNewsId(int channelNewsId) {
                this.channelNewsId = channelNewsId;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public int getIsHasAudio() {
                return isHasAudio;
            }

            public void setIsHasAudio(int isHasAudio) {
                this.isHasAudio = isHasAudio;
            }

            public int getIsHasTv() {
                return isHasTv;
            }

            public void setIsHasTv(int isHasTv) {
                this.isHasTv = isHasTv;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getTemplateType() {
                return templateType;
            }

            public void setTemplateType(int templateType) {
                this.templateType = templateType;
            }

            public int getIsHasSponsorships() {
                return isHasSponsorships;
            }

            public void setIsHasSponsorships(int isHasSponsorships) {
                this.isHasSponsorships = isHasSponsorships;
            }

            public int getIsHasVote() {
                return isHasVote;
            }

            public void setIsHasVote(int isHasVote) {
                this.isHasVote = isHasVote;
            }

            public int getIsPreload() {
                return isPreload;
            }

            public void setIsPreload(int isPreload) {
                this.isPreload = isPreload;
            }

            public int getIsWeather() {
                return isWeather;
            }

            public void setIsWeather(int isWeather) {
                this.isWeather = isWeather;
            }

            public int getTemplateId() {
                return templateId;
            }

            public void setTemplateId(int templateId) {
                this.templateId = templateId;
            }

            public int getNewsId() {
                return newsId;
            }

            public void setNewsId(int newsId) {
                this.newsId = newsId;
            }

            public List<String> getPics() {
                return pics;
            }

            public void setPics(List<String> pics) {
                this.pics = pics;
            }

            public void setPosition(int position) {
                this.position = position;
            }

            public void setScope(String scope) {
                this.scope = scope;
            }

            public void setData(DataEntity data) {
                this.data = data;
            }

            public void setRc(int rc) {
                this.rc = rc;
            }

            public void setGbcode(String gbcode) {
                this.gbcode = gbcode;
            }

            public void setAdType(int adType) {
                this.adType = adType;
            }

            public void setAppchn(String appchn) {
                this.appchn = appchn;
            }

            public void setNewschn(String newschn) {
                this.newschn = newschn;
            }

            public void setAdp_type(int adp_type) {
                this.adp_type = adp_type;
            }

            public void setLc(int lc) {
                this.lc = lc;
            }

            public void setAbposition(int abposition) {
                this.abposition = abposition;
            }

            public void setIconText(String iconText) {
                this.iconText = iconText;
            }

            public void setIconNight(String iconNight) {
                this.iconNight = iconNight;
            }

            public void setIconDay(String iconDay) {
                this.iconDay = iconDay;
            }

            public int getPosition() {
                return position;
            }

            public String getScope() {
                return scope;
            }

            public DataEntity getData() {
                return data;
            }

            public int getRc() {
                return rc;
            }

            public String getGbcode() {
                return gbcode;
            }

            public int getAdType() {
                return adType;
            }

            public String getAppchn() {
                return appchn;
            }

            public String getNewschn() {
                return newschn;
            }

            public int getAdp_type() {
                return adp_type;
            }

            public int getLc() {
                return lc;
            }

            public int getAbposition() {
                return abposition;
            }

            public String getIconText() {
                return iconText;
            }

            public String getIconNight() {
                return iconNight;
            }

            public String getIconDay() {
                return iconDay;
            }

            public static class DataEntity {
                private String position;
                private int du;
                private int weight;
                private String form;
                private String viewmonitor;
                private int tag;
                private String impressionid;
                /**
                 * text :
                 * admaster_imp : []
                 * width : 656
                 * imp : ["http://imp.optaim.com/201603/84ec2dbfdd861fcd00de8d6b54a8b640.php?a=99"]
                 * click_imp : []
                 * click : http://clk.optaim.com/event.ng/Type=click&FlightID=201603&TargetID=sohu&Values=84ec2dbf,dd861fcd,00de8d6b,54a8b640&AdID=11117025
                 * type : image
                 * miaozhen_click_imp : []
                 * height : 324
                 * file : http://images.sohu.com/saf/a2016/0321/wKiDRFbvg7OANlPVAACrIFqoBaU097656x324.jpg
                 * md5 : 20rpH0x610000000S74103VtV
                 * miaozhen_imp : []
                 * adcode : http://images.sohu.com/saf/a2016/0321/wKiDRFbvg7OANlPVAACrIFqoBaU097656x324.jpg
                 * admaster_click_imp : []
                 */

                private ResourceEntity resource;
                private int onform;
                private int offline;
                private String size;
                private int online;
                private String clickmonitor;
                private String adid;
                private String itemspaceid;
                /**
                 * dict : {"picture":"resource","title":"resource1"}
                 */

                private SpecialEntity special;
                private String monitorkey;
                /**
                 * text : 搜狐新闻新功能：定制开机图
                 * admaster_imp : []
                 * imp : ["http://imp.optaim.com/201603/84ec2dbfdd861fcd00de8d6b54a8b640.php?a=99"]
                 * miaozhen_imp : []
                 * md5 : 20rpH0x610000000S74103VtV
                 * click_imp : []
                 * click : http://clk.optaim.com/event.ng/Type=click&FlightID=201603&TargetID=sohu&Values=84ec2dbf,dd861fcd,00de8d6b,54a8b640&AdID=11117025
                 * adcode : 搜狐新闻新功能：定制开机图
                 * type : text
                 * miaozhen_click_imp : []
                 * admaster_click_imp : []
                 */

                private Resource1Entity resource1;

                public void setPosition(String position) {
                    this.position = position;
                }

                public void setDu(int du) {
                    this.du = du;
                }

                public void setWeight(int weight) {
                    this.weight = weight;
                }

                public void setForm(String form) {
                    this.form = form;
                }

                public void setViewmonitor(String viewmonitor) {
                    this.viewmonitor = viewmonitor;
                }

                public void setTag(int tag) {
                    this.tag = tag;
                }

                public void setImpressionid(String impressionid) {
                    this.impressionid = impressionid;
                }

                public void setResource(ResourceEntity resource) {
                    this.resource = resource;
                }

                public void setOnform(int onform) {
                    this.onform = onform;
                }

                public void setOffline(int offline) {
                    this.offline = offline;
                }

                public void setSize(String size) {
                    this.size = size;
                }

                public void setOnline(int online) {
                    this.online = online;
                }

                public void setClickmonitor(String clickmonitor) {
                    this.clickmonitor = clickmonitor;
                }

                public void setAdid(String adid) {
                    this.adid = adid;
                }

                public void setItemspaceid(String itemspaceid) {
                    this.itemspaceid = itemspaceid;
                }

                public void setSpecial(SpecialEntity special) {
                    this.special = special;
                }

                public void setMonitorkey(String monitorkey) {
                    this.monitorkey = monitorkey;
                }

                public void setResource1(Resource1Entity resource1) {
                    this.resource1 = resource1;
                }

                public String getPosition() {
                    return position;
                }

                public int getDu() {
                    return du;
                }

                public int getWeight() {
                    return weight;
                }

                public String getForm() {
                    return form;
                }

                public String getViewmonitor() {
                    return viewmonitor;
                }

                public int getTag() {
                    return tag;
                }

                public String getImpressionid() {
                    return impressionid;
                }

                public ResourceEntity getResource() {
                    return resource;
                }

                public int getOnform() {
                    return onform;
                }

                public int getOffline() {
                    return offline;
                }

                public String getSize() {
                    return size;
                }

                public int getOnline() {
                    return online;
                }

                public String getClickmonitor() {
                    return clickmonitor;
                }

                public String getAdid() {
                    return adid;
                }

                public String getItemspaceid() {
                    return itemspaceid;
                }

                public SpecialEntity getSpecial() {
                    return special;
                }

                public String getMonitorkey() {
                    return monitorkey;
                }

                public Resource1Entity getResource1() {
                    return resource1;
                }

                public static class ResourceEntity {
                    private String text;
                    private int width;
                    private String click;
                    private String type;
                    private int height;
                    private String file;
                    private String md5;
                    private String adcode;
                    private List<?> admaster_imp;
                    private List<String> imp;
                    private List<?> click_imp;
                    private List<?> miaozhen_click_imp;
                    private List<?> miaozhen_imp;
                    private List<?> admaster_click_imp;

                    public void setText(String text) {
                        this.text = text;
                    }

                    public void setWidth(int width) {
                        this.width = width;
                    }

                    public void setClick(String click) {
                        this.click = click;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }

                    public void setHeight(int height) {
                        this.height = height;
                    }

                    public void setFile(String file) {
                        this.file = file;
                    }

                    public void setMd5(String md5) {
                        this.md5 = md5;
                    }

                    public void setAdcode(String adcode) {
                        this.adcode = adcode;
                    }

                    public void setAdmaster_imp(List<?> admaster_imp) {
                        this.admaster_imp = admaster_imp;
                    }

                    public void setImp(List<String> imp) {
                        this.imp = imp;
                    }

                    public void setClick_imp(List<?> click_imp) {
                        this.click_imp = click_imp;
                    }

                    public void setMiaozhen_click_imp(List<?> miaozhen_click_imp) {
                        this.miaozhen_click_imp = miaozhen_click_imp;
                    }

                    public void setMiaozhen_imp(List<?> miaozhen_imp) {
                        this.miaozhen_imp = miaozhen_imp;
                    }

                    public void setAdmaster_click_imp(List<?> admaster_click_imp) {
                        this.admaster_click_imp = admaster_click_imp;
                    }

                    public String getText() {
                        return text;
                    }

                    public int getWidth() {
                        return width;
                    }

                    public String getClick() {
                        return click;
                    }

                    public String getType() {
                        return type;
                    }

                    public int getHeight() {
                        return height;
                    }

                    public String getFile() {
                        return file;
                    }

                    public String getMd5() {
                        return md5;
                    }

                    public String getAdcode() {
                        return adcode;
                    }

                    public List<?> getAdmaster_imp() {
                        return admaster_imp;
                    }

                    public List<String> getImp() {
                        return imp;
                    }

                    public List<?> getClick_imp() {
                        return click_imp;
                    }

                    public List<?> getMiaozhen_click_imp() {
                        return miaozhen_click_imp;
                    }

                    public List<?> getMiaozhen_imp() {
                        return miaozhen_imp;
                    }

                    public List<?> getAdmaster_click_imp() {
                        return admaster_click_imp;
                    }
                }

                public static class SpecialEntity {
                    /**
                     * picture : resource
                     * title : resource1
                     */

                    private DictEntity dict;

                    public void setDict(DictEntity dict) {
                        this.dict = dict;
                    }

                    public DictEntity getDict() {
                        return dict;
                    }

                    public static class DictEntity {
                        private String picture;
                        private String title;

                        public void setPicture(String picture) {
                            this.picture = picture;
                        }

                        public void setTitle(String title) {
                            this.title = title;
                        }

                        public String getPicture() {
                            return picture;
                        }

                        public String getTitle() {
                            return title;
                        }
                    }
                }

                public static class Resource1Entity {
                    private String text;
                    private String md5;
                    private String click;
                    private String adcode;
                    private String type;
                    private List<?> admaster_imp;
                    private List<String> imp;
                    private List<?> miaozhen_imp;
                    private List<?> click_imp;
                    private List<?> miaozhen_click_imp;
                    private List<?> admaster_click_imp;

                    public void setText(String text) {
                        this.text = text;
                    }

                    public void setMd5(String md5) {
                        this.md5 = md5;
                    }

                    public void setClick(String click) {
                        this.click = click;
                    }

                    public void setAdcode(String adcode) {
                        this.adcode = adcode;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }

                    public void setAdmaster_imp(List<?> admaster_imp) {
                        this.admaster_imp = admaster_imp;
                    }

                    public void setImp(List<String> imp) {
                        this.imp = imp;
                    }

                    public void setMiaozhen_imp(List<?> miaozhen_imp) {
                        this.miaozhen_imp = miaozhen_imp;
                    }

                    public void setClick_imp(List<?> click_imp) {
                        this.click_imp = click_imp;
                    }

                    public void setMiaozhen_click_imp(List<?> miaozhen_click_imp) {
                        this.miaozhen_click_imp = miaozhen_click_imp;
                    }

                    public void setAdmaster_click_imp(List<?> admaster_click_imp) {
                        this.admaster_click_imp = admaster_click_imp;
                    }

                    public String getText() {
                        return text;
                    }

                    public String getMd5() {
                        return md5;
                    }

                    public String getClick() {
                        return click;
                    }

                    public String getAdcode() {
                        return adcode;
                    }

                    public String getType() {
                        return type;
                    }

                    public List<?> getAdmaster_imp() {
                        return admaster_imp;
                    }

                    public List<String> getImp() {
                        return imp;
                    }

                    public List<?> getMiaozhen_imp() {
                        return miaozhen_imp;
                    }

                    public List<?> getClick_imp() {
                        return click_imp;
                    }

                    public List<?> getMiaozhen_click_imp() {
                        return miaozhen_click_imp;
                    }

                    public List<?> getAdmaster_click_imp() {
                        return admaster_click_imp;
                    }
                }
            }
        }

        @Override
        public String toString() {
            return "ArticlesEntity{" +
                    "statsType=" + statsType +
                    ", isHasAudio=" + isHasAudio +
                    ", isHasTv=" + isHasTv +
                    ", pos='" + pos + '\'' +
                    ", isRecom=" + isRecom +
                    ", templateType=" + templateType +
                    ", isHasSponsorships=" + isHasSponsorships +
                    ", isPreload=" + isPreload +
                    ", isWeather=" + isWeather +
                    ", carouselTime=" + carouselTime +
                    ", isFlash=" + isFlash +
                    ", newsType=" + newsType +
                    ", templateId=" + templateId +
                    ", commentNum=" + commentNum +
                    ", playTime='" + playTime + '\'' +
                    ", newsId=" + newsId +
                    ", newsItems=" + newsItems +
                    '}';
        }

        public static class DataEntity {
            private String position;
            private int du;
            private int weight;
            private String form;
            private String viewmonitor;
            private int tag;
            private String impressionid;
            /**
             * text :
             * admaster_imp : []
             * width : 360
             * imp : []
             * click_imp : []
             * click : http://win.dx168.com/wap/20160316tjx/index.html?sid=1648&reffer=1514701
             * type : image
             * miaozhen_click_imp : []
             * height : 234
             * file : http://images.sohu.com/saf/a2016/0321/wKiDRFbvvxaAFES_AABJY14a1ac788360x234.jpg
             * md5 : 20reC0x730000000SbJ103VWk
             * miaozhen_imp : []
             * adcode : http://images.sohu.com/saf/a2016/0321/wKiDRFbvvxaAFES_AABJY14a1ac788360x234.jpg
             * admaster_click_imp : []
             */

            private ResourceEntity resource;
            private int onform;
            private int offline;
            private String size;
            private int online;
            private String clickmonitor;
            private String adid;
            private String itemspaceid;
            /**
             * dict : {"summary":"resource2","picture":"resource","title":"resource1"}
             */

            private SpecialEntity special;
            /**
             * text :
             * admaster_imp : []
             * imp : []
             * miaozhen_imp : []
             * md5 : 20reC0x730000000SbJ103VWk
             * click_imp : []
             * click : http://win.dx168.com/wap/20160316tjx/index.html?sid=1648&reffer=1514701
             * adcode :
             * type : text
             * miaozhen_click_imp : []
             * admaster_click_imp : []
             */

            private Resource2Entity resource2;
            private String monitorkey;
            /**
             * text : 22小时改变你的账户余额
             * admaster_imp : []
             * imp : []
             * miaozhen_imp : []
             * md5 : 20reC0x730000000SbJ103VWk
             * click_imp : []
             * click : http://win.dx168.com/wap/20160316tjx/index.html?sid=1648&reffer=1514701
             * adcode : 22小时改变你的账户余额
             * type : text
             * miaozhen_click_imp : []
             * admaster_click_imp : []
             */

            private Resource1Entity resource1;

            public void setPosition(String position) {
                this.position = position;
            }

            public void setDu(int du) {
                this.du = du;
            }

            public void setWeight(int weight) {
                this.weight = weight;
            }

            public void setForm(String form) {
                this.form = form;
            }

            public void setViewmonitor(String viewmonitor) {
                this.viewmonitor = viewmonitor;
            }

            public void setTag(int tag) {
                this.tag = tag;
            }

            public void setImpressionid(String impressionid) {
                this.impressionid = impressionid;
            }

            public void setResource(ResourceEntity resource) {
                this.resource = resource;
            }

            public void setOnform(int onform) {
                this.onform = onform;
            }

            public void setOffline(int offline) {
                this.offline = offline;
            }

            public void setSize(String size) {
                this.size = size;
            }

            public void setOnline(int online) {
                this.online = online;
            }

            public void setClickmonitor(String clickmonitor) {
                this.clickmonitor = clickmonitor;
            }

            public void setAdid(String adid) {
                this.adid = adid;
            }

            public void setItemspaceid(String itemspaceid) {
                this.itemspaceid = itemspaceid;
            }

            public void setSpecial(SpecialEntity special) {
                this.special = special;
            }

            public void setResource2(Resource2Entity resource2) {
                this.resource2 = resource2;
            }

            public void setMonitorkey(String monitorkey) {
                this.monitorkey = monitorkey;
            }

            public void setResource1(Resource1Entity resource1) {
                this.resource1 = resource1;
            }

            public String getPosition() {
                return position;
            }

            public int getDu() {
                return du;
            }

            public int getWeight() {
                return weight;
            }

            public String getForm() {
                return form;
            }

            public String getViewmonitor() {
                return viewmonitor;
            }

            public int getTag() {
                return tag;
            }

            public String getImpressionid() {
                return impressionid;
            }

            public ResourceEntity getResource() {
                return resource;
            }

            public int getOnform() {
                return onform;
            }

            public int getOffline() {
                return offline;
            }

            public String getSize() {
                return size;
            }

            public int getOnline() {
                return online;
            }

            public String getClickmonitor() {
                return clickmonitor;
            }

            public String getAdid() {
                return adid;
            }

            public String getItemspaceid() {
                return itemspaceid;
            }

            public SpecialEntity getSpecial() {
                return special;
            }

            public Resource2Entity getResource2() {
                return resource2;
            }

            public String getMonitorkey() {
                return monitorkey;
            }

            public Resource1Entity getResource1() {
                return resource1;
            }

            public static class ResourceEntity {
                private String text;
                private int width;
                private String click;
                private String type;
                private int height;
                private String file;
                private String md5;
                private String adcode;
                private List<?> admaster_imp;
                private List<?> imp;
                private List<?> click_imp;
                private List<?> miaozhen_click_imp;
                private List<?> miaozhen_imp;
                private List<?> admaster_click_imp;

                public void setText(String text) {
                    this.text = text;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public void setClick(String click) {
                    this.click = click;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public void setHeight(int height) {
                    this.height = height;
                }

                public void setFile(String file) {
                    this.file = file;
                }

                public void setMd5(String md5) {
                    this.md5 = md5;
                }

                public void setAdcode(String adcode) {
                    this.adcode = adcode;
                }

                public void setAdmaster_imp(List<?> admaster_imp) {
                    this.admaster_imp = admaster_imp;
                }

                public void setImp(List<?> imp) {
                    this.imp = imp;
                }

                public void setClick_imp(List<?> click_imp) {
                    this.click_imp = click_imp;
                }

                public void setMiaozhen_click_imp(List<?> miaozhen_click_imp) {
                    this.miaozhen_click_imp = miaozhen_click_imp;
                }

                public void setMiaozhen_imp(List<?> miaozhen_imp) {
                    this.miaozhen_imp = miaozhen_imp;
                }

                public void setAdmaster_click_imp(List<?> admaster_click_imp) {
                    this.admaster_click_imp = admaster_click_imp;
                }

                public String getText() {
                    return text;
                }

                public int getWidth() {
                    return width;
                }

                public String getClick() {
                    return click;
                }

                public String getType() {
                    return type;
                }

                public int getHeight() {
                    return height;
                }

                public String getFile() {
                    return file;
                }

                public String getMd5() {
                    return md5;
                }

                public String getAdcode() {
                    return adcode;
                }

                public List<?> getAdmaster_imp() {
                    return admaster_imp;
                }

                public List<?> getImp() {
                    return imp;
                }

                public List<?> getClick_imp() {
                    return click_imp;
                }

                public List<?> getMiaozhen_click_imp() {
                    return miaozhen_click_imp;
                }

                public List<?> getMiaozhen_imp() {
                    return miaozhen_imp;
                }

                public List<?> getAdmaster_click_imp() {
                    return admaster_click_imp;
                }
            }

            public static class SpecialEntity {
                /**
                 * summary : resource2
                 * picture : resource
                 * title : resource1
                 */

                private DictEntity dict;

                public void setDict(DictEntity dict) {
                    this.dict = dict;
                }

                public DictEntity getDict() {
                    return dict;
                }

                public static class DictEntity {
                    private String summary;
                    private String picture;
                    private String title;

                    public void setSummary(String summary) {
                        this.summary = summary;
                    }

                    public void setPicture(String picture) {
                        this.picture = picture;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getSummary() {
                        return summary;
                    }

                    public String getPicture() {
                        return picture;
                    }

                    public String getTitle() {
                        return title;
                    }
                }
            }

            public static class Resource2Entity {
                private String text;
                private String md5;
                private String click;
                private String adcode;
                private String type;
                private List<?> admaster_imp;
                private List<?> imp;
                private List<?> miaozhen_imp;
                private List<?> click_imp;
                private List<?> miaozhen_click_imp;
                private List<?> admaster_click_imp;

                public void setText(String text) {
                    this.text = text;
                }

                public void setMd5(String md5) {
                    this.md5 = md5;
                }

                public void setClick(String click) {
                    this.click = click;
                }

                public void setAdcode(String adcode) {
                    this.adcode = adcode;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public void setAdmaster_imp(List<?> admaster_imp) {
                    this.admaster_imp = admaster_imp;
                }

                public void setImp(List<?> imp) {
                    this.imp = imp;
                }

                public void setMiaozhen_imp(List<?> miaozhen_imp) {
                    this.miaozhen_imp = miaozhen_imp;
                }

                public void setClick_imp(List<?> click_imp) {
                    this.click_imp = click_imp;
                }

                public void setMiaozhen_click_imp(List<?> miaozhen_click_imp) {
                    this.miaozhen_click_imp = miaozhen_click_imp;
                }

                public void setAdmaster_click_imp(List<?> admaster_click_imp) {
                    this.admaster_click_imp = admaster_click_imp;
                }

                public String getText() {
                    return text;
                }

                public String getMd5() {
                    return md5;
                }

                public String getClick() {
                    return click;
                }

                public String getAdcode() {
                    return adcode;
                }

                public String getType() {
                    return type;
                }

                public List<?> getAdmaster_imp() {
                    return admaster_imp;
                }

                public List<?> getImp() {
                    return imp;
                }

                public List<?> getMiaozhen_imp() {
                    return miaozhen_imp;
                }

                public List<?> getClick_imp() {
                    return click_imp;
                }

                public List<?> getMiaozhen_click_imp() {
                    return miaozhen_click_imp;
                }

                public List<?> getAdmaster_click_imp() {
                    return admaster_click_imp;
                }
            }

            public static class Resource1Entity {
                private String text;
                private String md5;
                private String click;
                private String adcode;
                private String type;
                private List<?> admaster_imp;
                private List<?> imp;
                private List<?> miaozhen_imp;
                private List<?> click_imp;
                private List<?> miaozhen_click_imp;
                private List<?> admaster_click_imp;

                public void setText(String text) {
                    this.text = text;
                }

                public void setMd5(String md5) {
                    this.md5 = md5;
                }

                public void setClick(String click) {
                    this.click = click;
                }

                public void setAdcode(String adcode) {
                    this.adcode = adcode;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public void setAdmaster_imp(List<?> admaster_imp) {
                    this.admaster_imp = admaster_imp;
                }

                public void setImp(List<?> imp) {
                    this.imp = imp;
                }

                public void setMiaozhen_imp(List<?> miaozhen_imp) {
                    this.miaozhen_imp = miaozhen_imp;
                }

                public void setClick_imp(List<?> click_imp) {
                    this.click_imp = click_imp;
                }

                public void setMiaozhen_click_imp(List<?> miaozhen_click_imp) {
                    this.miaozhen_click_imp = miaozhen_click_imp;
                }

                public void setAdmaster_click_imp(List<?> admaster_click_imp) {
                    this.admaster_click_imp = admaster_click_imp;
                }

                public String getText() {
                    return text;
                }

                public String getMd5() {
                    return md5;
                }

                public String getClick() {
                    return click;
                }

                public String getAdcode() {
                    return adcode;
                }

                public String getType() {
                    return type;
                }

                public List<?> getAdmaster_imp() {
                    return admaster_imp;
                }

                public List<?> getImp() {
                    return imp;
                }

                public List<?> getMiaozhen_imp() {
                    return miaozhen_imp;
                }

                public List<?> getClick_imp() {
                    return click_imp;
                }

                public List<?> getMiaozhen_click_imp() {
                    return miaozhen_click_imp;
                }

                public List<?> getAdmaster_click_imp() {
                    return admaster_click_imp;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "NewsBean{" +
                "shareRead=" + shareRead +
                ", channelName='" + channelName + '\'' +
                ", subInfo=" + subInfo +
                ", mainFocalId=" + mainFocalId +
                ", channelId=" + channelId +
                ", lastUpdateTime=" + lastUpdateTime +
                ", type='" + type + '\'' +
                ", shareContent='" + shareContent + '\'' +
                ", token='" + token + '\'' +
                ", isDefault=" + isDefault +
                ", preload=" + preload +
                ", localType=" + localType +
                ", focusPosition=" + focusPosition +
                ", viceFocalId=" + viceFocalId +
                ", articles=" + articles +
                '}';
    }
}