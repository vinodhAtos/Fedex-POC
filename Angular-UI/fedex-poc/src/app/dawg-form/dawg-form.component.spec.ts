import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DawgFormComponent } from './dawg-form.component';

describe('DawgFormComponent', () => {
  let component: DawgFormComponent;
  let fixture: ComponentFixture<DawgFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DawgFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DawgFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
