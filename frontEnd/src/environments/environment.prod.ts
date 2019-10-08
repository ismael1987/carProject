import { HttpHeaders } from '@angular/common/http';

export const environment = {
  production: true,
  base_url: "http://localhost:8080",
  get_cars_method: "getcars",
  rent_cars_method: "rentcar",
  get_user_info_method: "getuserinfo",
  get_rentals_method: "myrentals",
  return_car_method: "returncar",
  content_type_json: {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  },
  create_user_method : "createuser",
  login_method: "login",
  local_storage_element_name: "user"
};
