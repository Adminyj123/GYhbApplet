package com.gyhb.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name="AppletAgreement")
public class AppletAgreement implements Serializable {

    /** Id */
    @Id
    private String id ;
    /** MainTitle;主标题 */
    private String maintitle ;
    /** Subheading;副标题 */
    private String subheading ;
    /** Content;内容 */
    private String content ;
    /** Editor;编辑人 */
    private String editor ;
    /** EntryTime;录入时间 */
    private Date entrytime ;
    /** Category;类别 */
    private Integer category ;
    /** Outline;概要 */
    private String outline ;
    /** Cover;封面 */
    private String cover ;
    /** Sort;排序 */
    private String sort ;
    /** Bz;备注 */
    private String bz ;
    /** Addinfo0;预留字段0 */
    private String addinfo0 ;
    /** Addinfo1;预留字段1 */
    private String addinfo1 ;
    /** Addinfo2;预留字段2 */
    private String addinfo2 ;
    /** Addinfo3;预留字段3 */
    private String addinfo3 ;
    /** Addinfo4;预留字段4 */
    private String addinfo4 ;
    /** 创建时间;新增时间 */
    private Date createtime ;
    /** 更新时间;修改时间 */
    private Date updatetime ;

    /** Id */
    public String getId(){
        return this.id;
    }
    /** Id */
    public void setId(String id){
        this.id = id;
    }
    /** MainTitle;主标题 */
    public String getMaintitle(){
        return this.maintitle;
    }
    /** MainTitle;主标题 */
    public void setMaintitle(String maintitle){
        this.maintitle = maintitle;
    }
    /** Subheading;副标题 */
    public String getSubheading(){
        return this.subheading;
    }
    /** Subheading;副标题 */
    public void setSubheading(String subheading){
        this.subheading = subheading;
    }
    /** Content;内容 */
    public String getContent(){
        return this.content;
    }
    /** Content;内容 */
    public void setContent(String content){
        this.content = content;
    }
    /** Editor;编辑人 */
    public String getEditor(){
        return this.editor;
    }
    /** Editor;编辑人 */
    public void setEditor(String editor){
        this.editor = editor;
    }
    /** EntryTime;录入时间 */
    public Date getEntrytime(){
        return this.entrytime;
    }
    /** EntryTime;录入时间 */
    public void setEntrytime(Date entrytime){
        this.entrytime = entrytime;
    }
    /** Category;类别 */
    public Integer getCategory(){
        return this.category;
    }
    /** Category;类别 */
    public void setCategory(Integer category){
        this.category = category;
    }
    /** Outline;概要 */
    public String getOutline(){
        return this.outline;
    }
    /** Outline;概要 */
    public void setOutline(String outline){
        this.outline = outline;
    }
    /** Cover;封面 */
    public String getCover(){
        return this.cover;
    }
    /** Cover;封面 */
    public void setCover(String cover){
        this.cover = cover;
    }
    /** Sort;排序 */
    public String getSort(){
        return this.sort;
    }
    /** Sort;排序 */
    public void setSort(String sort){
        this.sort = sort;
    }
    /** Bz;备注 */
    public String getBz(){
        return this.bz;
    }
    /** Bz;备注 */
    public void setBz(String bz){
        this.bz = bz;
    }
    /** Addinfo0;预留字段0 */
    public String getAddinfo0(){
        return this.addinfo0;
    }
    /** Addinfo0;预留字段0 */
    public void setAddinfo0(String addinfo0){
        this.addinfo0 = addinfo0;
    }
    /** Addinfo1;预留字段1 */
    public String getAddinfo1(){
        return this.addinfo1;
    }
    /** Addinfo1;预留字段1 */
    public void setAddinfo1(String addinfo1){
        this.addinfo1 = addinfo1;
    }
    /** Addinfo2;预留字段2 */
    public String getAddinfo2(){
        return this.addinfo2;
    }
    /** Addinfo2;预留字段2 */
    public void setAddinfo2(String addinfo2){
        this.addinfo2 = addinfo2;
    }
    /** Addinfo3;预留字段3 */
    public String getAddinfo3(){
        return this.addinfo3;
    }
    /** Addinfo3;预留字段3 */
    public void setAddinfo3(String addinfo3){
        this.addinfo3 = addinfo3;
    }
    /** Addinfo4;预留字段4 */
    public String getAddinfo4(){
        return this.addinfo4;
    }
    /** Addinfo4;预留字段4 */
    public void setAddinfo4(String addinfo4){
        this.addinfo4 = addinfo4;
    }
    /** 创建时间;新增时间 */
    public Date getCreatetime(){
        return this.createtime;
    }
    /** 创建时间;新增时间 */
    public void setCreatetime(Date createtime){
        this.createtime = createtime;
    }
    /** 更新时间;修改时间 */
    public Date getUpdatetime(){
        return this.updatetime;
    }
    /** 更新时间;修改时间 */
    public void setUpdatetime(Date updatetime){
        this.updatetime = updatetime;
    }


}
