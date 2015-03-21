<meta charset="UTF-8">
<div class="modal fade bs-example-modal-sm" id="signUpForm"
     tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title text-info" id="exampleModalLabel">Đăng ký tài khoản</h4>
            </div>

            <form method="post" action="signup">
                <div class="radio-inline">
                    <label class="radio-inline"><input type="radio" name="type" value="student" checked="checked">Sinh viên</label>
                </div>
                <div class="radio-inline">
                    <label class="radio-inline"><input type="radio" name="type" value="company">Doanh nghiệp</label>
                </div>
                <div class="modal-body">
                    <div class="form-group form-inline">
                        <label for="fullname">Họ tên</label> <input type="text"
                                                                    class="form-control pull-right" id="fullname" name="fullname"
                                                                    placeholder="Họ và tên">
                    </div>
                    <div class="form-group form-inline">
                        <label for="username">Username</label> <input type="text"
                                                                      class="form-control pull-right" id="username" name="username"
                                                                      placeholder="Enter username">
                    </div>
                    <div class="form-group form-inline">
                        <label for="email">Email</label> <input type="email"
                                                                class="form-control pull-right" id="email" name="email"
                                                                placeholder="Enter email">
                    </div>
                    <div class="form-group form-inline">
                        <label for="password">Mật khẩu</label> <input type="password"
                                                                      class="form-control pull-right" id="password" name="password"
                                                                      placeholder="Tối thiểu 8 ký tự">
                    </div>
                    <div class="form-group form-inline">
                        <label for="repassword">Xác nhận</label> <input type="password"
                                                                        class="form-control pull-right" id="repassword" name="repassword"
                                                                        placeholder="Điền lại mật khẩu">
                    </div>
                    <div class="form-group form-inline">
                        <label for="birthday">Ngày sinh</label> <input type="date"
                                                                       class="form-control pull-right" id="birthday" name="birthday"
                                                                       value="1950-01-01">
                    </div>
                    <div class="radio-inline">
                        <label class="radio-inline"><input type="radio" name="gender" value="male" checked="checked">Nam</label>
                    </div>
                    <div class="radio-inline">
                        <label class="radio-inline"><input type="radio" name="gender" value="female">Nữ</label>
                    </div>
                    <div class="form-group form-inline">
                        <label for="address">Địa chỉ</label> <input type="text"
                                                                    class="form-control pull-right" id="address" name="address"
                                                                    placeholder="Chỗ ở hiện nay">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Hủy</button>
                    <button type="submit" class="btn btn-primary">Đăng ký</button>
                </div>
            </form>
        </div>
    </div>
</div>