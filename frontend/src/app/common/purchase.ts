import { Address } from "./address";
import { Customer } from "./customer";
import { Order } from "./order";
import { OrderItem } from "./order-item";
import {AbstractControl, ɵFormGroupRawValue, ɵGetProperty, ɵTypedOrUntyped} from "@angular/forms";
import {Sex} from "./Sex";

export class Purchase {
  customer!: Customer;
  shippingAddress!: Address;
  //billingAddress!: Address;
  //order!: Order;
  //orderItems!: OrderItem[];
  Country!: AbstractControl<ɵGetProperty<ɵTypedOrUntyped<any, ɵFormGroupRawValue<any>, any>, "billingAddress.country">> | null;
  firstName!: AbstractControl<ɵGetProperty<ɵTypedOrUntyped<any, ɵFormGroupRawValue<any>, any>, "customer.firstName">> | null;
  lastName!: AbstractControl<ɵGetProperty<ɵTypedOrUntyped<any, ɵFormGroupRawValue<any>, any>, "customer.lastName">> | null;
  email!: string;
  Date !: Date;
  age !: AbstractControl<ɵGetProperty<ɵTypedOrUntyped<any, ɵFormGroupRawValue<any>, any>, "customer.age">> | null;
  sex !: AbstractControl<ɵGetProperty<ɵTypedOrUntyped<any, ɵFormGroupRawValue<any>, any>, "customer.sex">> | null;
}
