import {AbstractControl, ɵFormGroupRawValue, ɵGetProperty, ɵTypedOrUntyped} from "@angular/forms";

export class Customer {
  firstName!: AbstractControl<ɵGetProperty<ɵTypedOrUntyped<any, ɵFormGroupRawValue<any>, any>, "customer.firstName">> | null;
  lastName!: AbstractControl<ɵGetProperty<ɵTypedOrUntyped<any, ɵFormGroupRawValue<any>, any>, "customer.lastName">> | null;
  email!: string;
  Date !: Date;
  age !: AbstractControl<ɵGetProperty<ɵTypedOrUntyped<any, ɵFormGroupRawValue<any>, any>, "customer.age">> | null;
  sex !: AbstractControl<ɵGetProperty<ɵTypedOrUntyped<any, ɵFormGroupRawValue<any>, any>, "customer.sex">> | null;
}
