import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DawgListComponent } from './dawg-list.component';

describe('DawgListComponent', () => {
  let component: DawgListComponent;
  let fixture: ComponentFixture<DawgListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DawgListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DawgListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
