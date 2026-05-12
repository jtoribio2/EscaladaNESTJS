import { Test, TestingModule } from '@nestjs/testing';
import { EscaladorsService } from './escaladors.service';

describe('EscaladorsService', () => {
  let service: EscaladorsService;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      providers: [EscaladorsService],
    }).compile();

    service = module.get<EscaladorsService>(EscaladorsService);
  });

  it('should be defined', () => {
    expect(service).toBeDefined();
  });
});
