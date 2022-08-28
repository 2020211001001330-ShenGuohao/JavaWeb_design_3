function exit() {
    if(confirm("您确定退出吗???")){
        window.location.href="logout"
    }
}


function delete_user(username,password) {
    if(confirm("确定删除\nusername: "+username+ "\npassword: "+password+ "\n这条信息?")){
        window.location.href="delete_user?delete_user_username="+username;
    }
}


function delete_warehouse(wno,wname) {
    if(confirm("确定删除\nwno: "+wno+ "\nwname: "+wname+ "\n这条信息?")){
        window.location.href="delete_warehouse?delete_warehouse_wno="+wno;
    }/*else {
                window.location.href="query_warehouse";
            }*/
}

function delete_staff(sno,sname,ssex,sage,sedu,wno) {
    if(confirm("确定删除\nSno: "+sno+ "\nSname: "+sname+"\nSsex: "+ssex+"\nSage: "+sage+"\nSedu:"+sedu+"\nWno: "+wno+ "\n这条信息?")){
        window.location.href="delete_staff?delete_staff_sno="+sno;
    }/*else{
                window.location.href="query_staff";
            }*/
}

function delete_orderd(Ono,Dno,Cno,Osum,Bdate) {
    if(confirm("确定删除\nOno: "+Ono+ "\nDno: "+Dno+"\nCno:"+Cno+"\nOsum:"+Osum+"\nBdate:"+Bdate+"这条信息?")){
        window.location.href="delete_orderd?delete_orderd_ono="+Ono;
    }/*else{
                window.location.href="query_orderd";
            }*/
}

function delete_drag(Dno,Dname,Dsum,Dprice,Wno) {
    if(confirm("确定删除?\nDno:"+Dno+"\n"+"Dname:"+Dname+"\n"+"Dsum:"+Dsum+"\n"+"Dprice:"+Dprice+"\n"+"Wno:"+Wno+"\n这条信息?")){
        window.location.href="delete_drag?delete_drag_dno="+Dno;
    }/*else{
                window.location.href="query_drag";
            }*/
}

function delete_client(cno,cname,ctel) {
    if(confirm("确定删除\ncno: "+cno+ "\ncname: "+cname+"\nctel: "+ctel+ "\n这条信息?")){
        window.location.href="delete_client?delete_client_cno="+cno;
    }/*else{
                window.location.href="query_client";
            }*/
}

