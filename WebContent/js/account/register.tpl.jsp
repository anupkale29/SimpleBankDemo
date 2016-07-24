<div class="row">
  <h1 class="page-header">
      Register
  </h1>
  <form ng-submit="register()">
      <div class="form-group">
          <label>Username:</label>
          <input type="text" ng-model="user.userName" class="form-control" />
      </div>
      <div class="form-group">
          <label>Email:</label>
          <input type="email" ng-model="user.userId" class="form-control" />
      </div>
      <div class="form-group">
          <label>Password:</label>
          <input type="password" ng-model="user.password" class="form-control" />
      </div>
      <div class="form-group">
          <label>Conform Password:</label>
          <input type="password" ng-model="user.conformPassword" class="form-control" />
      </div>
      <button class="btn btn-success" type="submit">Register</button>
  </form>
</div>

