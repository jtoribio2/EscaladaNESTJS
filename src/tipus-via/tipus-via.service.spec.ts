import { Test, TestingModule } from '@nestjs/testing';
import { TipusViaService } from './tipus-via.service';

describe('TipusViaService', () => {
  let service: TipusViaService;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      providers: [TipusViaService],
    }).compile();

    service = module.get<TipusViaService>(TipusViaService);
  });

  it('should be defined', () => {
    expect(service).toBeDefined();
  });
});
