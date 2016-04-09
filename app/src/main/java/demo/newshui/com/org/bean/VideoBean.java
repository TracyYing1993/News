package demo.newshui.com.org.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/3/21.
 */
public class VideoBean {


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

    public static class DataEntity {
        private int count;
        private int has_next;
        private int cursor;
        /**
         * column_id : 615
         * content_size : 6
         * load_more : 1
         * column_type : 18
         * name : 恶搞吐槽
         * action_list : []
         * template : {"main_title":"video_name","sub_title":"nickname","bottom_title":"play_count","template_id":14}
         * data_list : [{"vid":83229803,"aid":1000000563028,"site":2,"video_name":"中国奇葩Pizza惊呆老外","data_type":34,"hor_w8_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_320,h_180/p224/2016/3/18/11/24/6_154659c6535g102SysCutcloud_83229803_7_6b.jpg","play_count":4927,"user_id":289466293,"nickname":"张逗张花","priority":0,"album_name":"【老美你怎么看】第三季","album_hor_small_pic":"http://photocdn.sohu.com/tvpgc/20160318/dXBsb2FkRmlsZV8zXzE0NTgyNzA0MTg2MjQ=_43_2.jpg"},{"vid":83229099,"aid":1000000375596,"site":2,"video_name":"哔了狗！论损友到底有多损","data_type":34,"hor_w6_pic":"http://001.img.pu.sohu.com.cn/group1/M01/90/A5/MTAuMTAuODguNzk=/dXBsb2FkRmlsZV8zXzE0NTgyNzAzMDkzMTQ=/cut@m=force,w=240,h=135.jpg","hor_w8_pic":"http://001.img.pu.sohu.com.cn/group1/M01/90/A5/MTAuMTAuODguNzk=/dXBsb2FkRmlsZV8zXzE0NTgyNzAzMDkzMTQ=/cut@m=force,w=320,h=180.jpg","play_count":71392,"user_id":247245585,"nickname":"小题影视","priority":1,"album_name":"郑在秀","album_hor_small_pic":"http://photocdn.sohu.com/tvpgc/20150921/13436476_14cb86ad7d8g201b_43_3.jpg"},{"vid":83244627,"aid":1000000362766,"site":2,"video_name":"盘点选秀舞台上的奇葩趣事","data_type":34,"hor_w6_pic":"http://001.img.pu.sohu.com.cn/group3/M06/94/0C/MTAuMTAuODguODM=/dXBsb2FkRmlsZV8zXzE0NTg0MDMzMjA4Nzk=/cut@m=force,w=240,h=135.jpg","hor_w8_pic":"http://001.img.pu.sohu.com.cn/group3/M06/94/0C/MTAuMTAuODguODM=/dXBsb2FkRmlsZV8zXzE0NTg0MDMzMjA4Nzk=/cut@m=force,w=320,h=180.jpg","play_count":30160,"user_id":202939688,"nickname":"DS女老诗","priority":2,"album_name":"萝莉说趣事","album_hor_small_pic":"http://photocdn.sohu.com/tvpgc/20150216/53468100_14b995f82ecg201b_43_3.jpg"},{"vid":83227133,"aid":1000000200850,"site":2,"video_name":"唐唐神吐槽：最浪美女战队","data_type":34,"hor_w6_pic":"http://001.img.pu.sohu.com.cn/group1/M09/90/70/MTAuMTAuODguODA=/dXBsb2FkRmlsZV8zXzE0NTgyNTQwMTg1MzY=/cut@m=force,w=240,h=135.jpg","hor_w8_pic":"http://001.img.pu.sohu.com.cn/group1/M09/90/70/MTAuMTAuODguODA=/dXBsb2FkRmlsZV8zXzE0NTgyNTQwMTg1MzY=/cut@m=force,w=320,h=180.jpg","play_count":238186,"user_id":196262702,"nickname":"Big笑工坊","priority":3,"album_name":"Big笑工坊","album_hor_small_pic":"http://photocdn.sohu.com/tvpgc/20140923/u3439447_149316e1729g201b_43_3.jpg"},{"vid":83227432,"aid":1000000201388,"site":2,"video_name":"美女健身房销魂叫声虐屌丝","data_type":34,"hor_w6_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_240,h_135/p223/2016/3/18/8/27/6_1546514e5eag104SysCutcloud_83227432_7_6b.jpg","hor_w8_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_320,h_180/p223/2016/3/18/8/27/6_1546514e5eag104SysCutcloud_83227432_7_6b.jpg","play_count":320832,"user_id":229900607,"nickname":"摧绵大湿","priority":4,"album_name":"催绵大湿","album_hor_small_pic":"http://photocdn.sohu.com/tvpgc/20150407/u3439447_149c7653b74g201b_43_3.jpg"},{"vid":83215119,"aid":1000000201090,"site":2,"video_name":"绝交！闺蜜掀裙子恶作剧","data_type":34,"hor_w6_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_240,h_135/p225/2016/3/17/0/5/6_1545e232f47g102SysCutcloud_83215119_7_5b.jpg","hor_w8_pic":"http://img.my.tv.sohu.com.cn/o_zoom,w_320,h_180/p225/2016/3/17/0/5/6_1545e232f47g102SysCutcloud_83215119_7_5b.jpg","play_count":294259,"user_id":205090153,"nickname":"春se无边1983","priority":5,"album_name":"春色无边恶搞","album_hor_small_pic":"http://photocdn.sohu.com/tvpgc/20150201/u3439447_1494ade73b9g201b_43_3.jpg"}]
         */

        private List<ColumnsEntity> columns;

        public void setCount(int count) {
            this.count = count;
        }

        public void setHas_next(int has_next) {
            this.has_next = has_next;
        }

        public void setCursor(int cursor) {
            this.cursor = cursor;
        }

        public void setColumns(List<ColumnsEntity> columns) {
            this.columns = columns;
        }

        public int getCount() {
            return count;
        }

        public int getHas_next() {
            return has_next;
        }

        public int getCursor() {
            return cursor;
        }

        public List<ColumnsEntity> getColumns() {
            return columns;
        }

        public static class ColumnsEntity {
            private int column_id;
            private int content_size;
            private int load_more;
            private int column_type;
            private String name;
            /**
             * main_title : video_name
             * sub_title : nickname
             * bottom_title : play_count
             * template_id : 14
             */

            private TemplateEntity template;
            private List<?> action_list;
            /**
             * vid : 83229803
             * aid : 1000000563028
             * site : 2
             * video_name : 中国奇葩Pizza惊呆老外
             * data_type : 34
             * hor_w8_pic : http://img.my.tv.sohu.com.cn/o_zoom,w_320,h_180/p224/2016/3/18/11/24/6_154659c6535g102SysCutcloud_83229803_7_6b.jpg
             * play_count : 4927
             * user_id : 289466293
             * nickname : 张逗张花
             * priority : 0
             * album_name : 【老美你怎么看】第三季
             * album_hor_small_pic : http://photocdn.sohu.com/tvpgc/20160318/dXBsb2FkRmlsZV8zXzE0NTgyNzA0MTg2MjQ=_43_2.jpg
             */

            private List<DataListEntity> data_list;

            public void setColumn_id(int column_id) {
                this.column_id = column_id;
            }

            public void setContent_size(int content_size) {
                this.content_size = content_size;
            }

            public void setLoad_more(int load_more) {
                this.load_more = load_more;
            }

            public void setColumn_type(int column_type) {
                this.column_type = column_type;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setTemplate(TemplateEntity template) {
                this.template = template;
            }

            public void setAction_list(List<?> action_list) {
                this.action_list = action_list;
            }

            public void setData_list(List<DataListEntity> data_list) {
                this.data_list = data_list;
            }

            public int getColumn_id() {
                return column_id;
            }

            public int getContent_size() {
                return content_size;
            }

            public int getLoad_more() {
                return load_more;
            }

            public int getColumn_type() {
                return column_type;
            }

            public String getName() {
                return name;
            }

            public TemplateEntity getTemplate() {
                return template;
            }

            public List<?> getAction_list() {
                return action_list;
            }

            public List<DataListEntity> getData_list() {
                return data_list;
            }

            public static class TemplateEntity {
                private String main_title;
                private String sub_title;
                private String bottom_title;
                private int template_id;

                public void setMain_title(String main_title) {
                    this.main_title = main_title;
                }

                public void setSub_title(String sub_title) {
                    this.sub_title = sub_title;
                }

                public void setBottom_title(String bottom_title) {
                    this.bottom_title = bottom_title;
                }

                public void setTemplate_id(int template_id) {
                    this.template_id = template_id;
                }

                public String getMain_title() {
                    return main_title;
                }

                public String getSub_title() {
                    return sub_title;
                }

                public String getBottom_title() {
                    return bottom_title;
                }

                public int getTemplate_id() {
                    return template_id;
                }

                @Override
                public String toString() {
                    return "TemplateEntity{" +
                            "main_title='" + main_title + '\'' +
                            ", sub_title='" + sub_title + '\'' +
                            ", bottom_title='" + bottom_title + '\'' +
                            ", template_id=" + template_id +
                            '}';
                }
            }

            public static class DataListEntity {
                private int vid;
                private long aid;
                private int site;
                private String video_name;
                private int data_type;
                private String hor_w8_pic;
                private int play_count;
                private int user_id;
                private String nickname;
                private int priority;
                private String album_name;
                private String album_hor_small_pic;

                public void setVid(int vid) {
                    this.vid = vid;
                }

                public void setAid(long aid) {
                    this.aid = aid;
                }

                public void setSite(int site) {
                    this.site = site;
                }

                public void setVideo_name(String video_name) {
                    this.video_name = video_name;
                }

                public void setData_type(int data_type) {
                    this.data_type = data_type;
                }

                public void setHor_w8_pic(String hor_w8_pic) {
                    this.hor_w8_pic = hor_w8_pic;
                }

                public void setPlay_count(int play_count) {
                    this.play_count = play_count;
                }

                public void setUser_id(int user_id) {
                    this.user_id = user_id;
                }

                public void setNickname(String nickname) {
                    this.nickname = nickname;
                }

                public void setPriority(int priority) {
                    this.priority = priority;
                }

                public void setAlbum_name(String album_name) {
                    this.album_name = album_name;
                }

                public void setAlbum_hor_small_pic(String album_hor_small_pic) {
                    this.album_hor_small_pic = album_hor_small_pic;
                }

                public int getVid() {
                    return vid;
                }

                public long getAid() {
                    return aid;
                }

                public int getSite() {
                    return site;
                }

                public String getVideo_name() {
                    return video_name;
                }

                public int getData_type() {
                    return data_type;
                }

                public String getHor_w8_pic() {
                    return hor_w8_pic;
                }

                public int getPlay_count() {
                    return play_count;
                }

                public int getUser_id() {
                    return user_id;
                }

                public String getNickname() {
                    return nickname;
                }

                public int getPriority() {
                    return priority;
                }

                public String getAlbum_name() {
                    return album_name;
                }

                public String getAlbum_hor_small_pic() {
                    return album_hor_small_pic;
                }

                @Override
                public String toString() {
                    return "DataListEntity{" +
                            "vid=" + vid +
                            ", aid=" + aid +
                            ", site=" + site +
                            ", video_name='" + video_name + '\'' +
                            ", data_type=" + data_type +
                            ", hor_w8_pic='" + hor_w8_pic + '\'' +
                            ", play_count=" + play_count +
                            ", user_id=" + user_id +
                            ", nickname='" + nickname + '\'' +
                            ", priority=" + priority +
                            ", album_name='" + album_name + '\'' +
                            ", album_hor_small_pic='" + album_hor_small_pic + '\'' +
                            '}';
                }
            }

            @Override
            public String toString() {
                return "ColumnsEntity{" +
                        "column_id=" + column_id +
                        ", content_size=" + content_size +
                        ", load_more=" + load_more +
                        ", column_type=" + column_type +
                        ", name='" + name + '\'' +
                        ", template=" + template +
                        ", action_list=" + action_list +
                        ", data_list=" + data_list +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "DataEntity{" +
                    "count=" + count +
                    ", has_next=" + has_next +
                    ", cursor=" + cursor +
                    ", columns=" + columns +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "VideoBean{" +
                "status=" + status +
                ", data=" + data +
                ", statusText='" + statusText + '\'' +
                '}';
    }
}
