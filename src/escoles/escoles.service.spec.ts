import { Test, TestingModule } from '@nestjs/testing';
import { EscolesService } from './escoles.service';

describe('EscolesService', () => {
  let service: EscolesService;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      providers: [EscolesService],
    }).compile();

    service = module.get<EscolesService>(EscolesService);
  });

  it('should be defined', () => {
    expect(service).toBeDefined();
  });
});
