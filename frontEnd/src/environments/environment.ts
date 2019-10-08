// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.
import { HttpHeaders } from '@angular/common/http';

export const environment = {
  production: false,
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
  create_user_method : "v1/customer",
  login_method: "login",
  local_storage_element_name: "user"
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
