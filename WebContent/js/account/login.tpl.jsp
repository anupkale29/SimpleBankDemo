<div class="row">
  <h1 class="page-header">
      Login
  </h1>
  <form ng-submit="login()">
      <div class="form-group">
          <label>Username:</label>
          <input type="email" ng-model="user.userId" class="form-control"/>
      </div>
      <div class="form-group">
          <label>Password:</label>
          <input type="password" ng-model="user.password" class="form-control"/>
      </div>
      <button class="btn btn-success" type="submit">Login</button>
  </form>
</div>
