import {AbstractControl, ɵFormGroupRawValue, ɵGetProperty, ɵTypedOrUntyped} from "@angular/forms";

export class Address {
  street!: string;
  city!: string;
  state!: string;
  country!: AbstractControl<ɵGetProperty<ɵTypedOrUntyped<any, ɵFormGroupRawValue<any>, any>, "billingAddress.country">> | null;
  zipCode!: string;
}
