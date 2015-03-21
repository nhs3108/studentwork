<meta charset="UTF-8">
<div class="modal fade bs-example-modal-sm" id="loginForm" tabindex="-1"
     role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title text-info" id="exampleModalLabel">Đăng nhập</h4>
            </div>
            <form method="post" action="login">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="username">Tên đăng nhập</label> <input type="text"
                                                                                class="form-control" id="username" name="username"
                                                                                placeholder="Enter email">
                    </div>
                    <div class="form-group">
                        <label for="password">Mật khẩu</label> <input type="password"
                                                                          class="form-control" id="password" name="password"
                                                                          placeholder="Password">
                    </div>
                    <div class="checkbox">
                        <label> <input type="checkbox"> Ghi nhớ!
                        </label>
                    </div>


                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Hủy</button>
                    <button type="submit" class="btn btn-primary">Đăng nhập</button>
                </div>
            </form>
        </div>
    </div>
</div>